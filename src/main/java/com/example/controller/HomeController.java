package com.example.controller;

import com.example.model.Lecture;
import com.example.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private LectureRepository lectureRepository;

    @GetMapping("/home")
    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
       // model.put("name", name);
        return "/home";
    }
    @GetMapping("/lecture")
    public String lecture(String title,String text,String author, Map<String, Object> model){
        //Iterable<Lecture> lectures = lectureRepository.GetAllLecture();
       // model.put("lecture",lectures);
        return "lecture";
    }

}
