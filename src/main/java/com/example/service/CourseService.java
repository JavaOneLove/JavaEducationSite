package com.example.service;

import com.example.model.Course;
import com.example.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> GetAllCourse() {
        List<Course> list = new ArrayList<>();
        courseRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    public void Save(Course course) {
        courseRepository.save(course);
    }
    public Course GetCourseById(int id){
       return courseRepository.findById(id).get();
    }
}
