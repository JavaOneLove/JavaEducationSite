package com.example.service;

import com.example.model.LectureCourse;
import com.example.repository.LectureCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectureCourseService {
    @Autowired
    private LectureCourseRepository lectureCourseRepository;

    public List<LectureCourse> GetAllLectureCourse() {
        List<LectureCourse> list = new ArrayList<>();
        lectureCourseRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public void Save(LectureCourse lectureCourse) {
        lectureCourseRepository.save(lectureCourse);
    }
}
