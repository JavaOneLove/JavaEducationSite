package com.example.controller;

import com.example.model.Course;
import com.example.model.Lecture;
import com.example.model.User;
import com.example.service.CourseService;
import com.example.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class HomeController {
    @Autowired
    private LectureService lectureService;
    @Autowired
    private CourseService courseService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/home")
    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {

        return "home";
    }
    @GetMapping(value = "/course/{id}")
    public String lecture(@PathVariable int id, Map<String, Object> model) throws NullPointerException {
        List<Lecture> lectures = lectureService.GetAllLecture();
        ArrayList<Lecture> lecList = new ArrayList<Lecture>();

        for (Lecture lecture : lectures) {
            if (lecture.getCourse_id().equals(id)) {
                lecList.add(lecture);
            }
        }
            model.put("lectures",lecList);
        return "lecture";
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
        return "redirect:/lecture";
    }
    @GetMapping("/course")
    public String course(Map<String,Object> model){
        Iterable<Course> courses = courseService.GetAllCourse();
        model.put("courses",courses);

        return "course";
    }


}
