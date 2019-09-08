package com.example.controller;

import com.example.model.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.aspectj.runtime.internal.Conversions.intValue;

@Controller
public class HomeController {
    @Autowired
    private MarkService markService;
    @Autowired
    private LectureService lectureService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private QuestionAnswerService questionAnswerService;
    @Autowired
    private TestService testService;

    @Value("${upload.path}")
    private String uploadPath;

    private int questionCurseId;

    @GetMapping("/home")
    public String home(Map<String,Object> model,@AuthenticationPrincipal User user) {
            model.put("User",user);
        return "home";
    }
    @GetMapping(value = "/course/{id}")
    public String lecture(@PathVariable int id, Map<String, Object> model) throws NullPointerException {
        List<Lecture> lectures = lectureService.GetAllLecture();
        List<Course> courses = courseService.GetAllCourse();
        List<Test> tests = testService.GetAllTest();
        ArrayList<Lecture> lecList = new ArrayList<>();

        for (Lecture lecture : lectures) {
            if (lecture.getCourse_id().equals(id)) {
                lecList.add(lecture);
            }
        }
            model.put("tests",tests);
            model.put("courses",courses);
            model.put("lectures",lecList);
        return "lecture";
    }
    @PostMapping("/course/{id}")
    public String TestCreate(@RequestParam(name="select") int Curse_id){
        questionCurseId = Curse_id;
        return "redirect:/createTest";
    }
    @GetMapping("/addLecture")
    public String aLecture(Map<String,Object> model){
        Iterable<Course> courses = courseService.GetAllCourse();
        model.put("courses",courses);
        return "addLecture";
    }
    @PostMapping("/addLecture")
    public String addLecture(@AuthenticationPrincipal User user,
                             @RequestParam String title,
                             @RequestParam String text,
                             @RequestParam Integer select,
                             @RequestParam("filename") MultipartFile file) throws IOException {
        Lecture lecture = new Lecture(title, text, user.getUsername(),select);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadFolder = new File(uploadPath);

            if (!uploadFolder.exists()) {
                 uploadFolder.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            lecture.setFilename(resultFilename);
        }
        lectureService.Save(lecture);
        return "redirect:/course";
    }
    @GetMapping("/course")
    public String course(Map<String,Object> model){
        Iterable<Course> courses = courseService.GetAllCourse();
        model.put("courses",courses);

        return "course";
    }
    @GetMapping("/createTest")
    public String createTest(Map<String,Object> model){
        return "createTest";
    }
    @PostMapping("/createTest")
        public String createTest(@RequestParam(value = "Count") String count,
                                 @RequestParam(value = "question[]") String[] question,
                                 @RequestParam(value = "answer[]") String[] answer,
                                 @RequestParam(value = "title") String title){
        Test test = new Test(title,questionCurseId);
        testService.Save(test);
            SaveTest(answer,question,test,count);

        return "home";
    }
    private void SaveTest( String[] MasAns,String[] MasQue, Test test, String questionVal){
            for(int i = 0; i<= Integer.parseInt(questionVal) - 1; i++){
                if (!MasAns[i].equals("")&& !MasQue[i].equals("")){
                    QuestionAnswer questionAnswer = new QuestionAnswer(MasAns[i],MasQue[i],test);
                    questionAnswerService.Save(questionAnswer);
                }
        }
    }
    @GetMapping("/test/{id}")
    public String Test(Map<String,Object> model,@PathVariable int id){
        Iterable<QuestionAnswer> questionAnswers = questionAnswerService.GetAllAnswerQuestion();
        ArrayList<QuestionAnswer> qA = new ArrayList<>();
        for (QuestionAnswer qa:questionAnswers) {
                if (qa.getTest().getId().equals(id))
                    qA.add(qa);
        }
        model.put("AnswerList",qA);
        return "test";
    }
    @PostMapping("/test/{id}")
    public String PassTest(@AuthenticationPrincipal User user,
                           @RequestParam(value = "answer[]") String[] answer,
                           @RequestParam( value = "AnswerList") ArrayList<QuestionAnswer> ans,
                           @PathVariable int id){
        String[] AnswerMassive = new String[answer.length];
        int i = 0;
        for(QuestionAnswer qa:ans){
           AnswerMassive[i] = qa.getAnswer();
            i++;
        }
        Mark mark = new Mark(intValue(CheckTest(answer,AnswerMassive)),user,testService.GetAllTest().get(id));
        return "test";
    }
    private double CheckTest(String[] ArrayAnswer, String[] ans){
        int pass = 0;
        for(int i = 0; i < ans.length;i++){
            if (ArrayAnswer[i].toLowerCase().equals(ans[i].toLowerCase())){
                pass ++;
            }
        }
        double mark = (pass * 100) / ans.length;
        return mark;
    }
}
