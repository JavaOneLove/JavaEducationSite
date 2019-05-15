package com.example.service;

import com.example.model.Lecture;
import com.example.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectureService  {
    @Autowired
    private LectureRepository lectureRepository;

    public List<Lecture> GetAllLecture() {
        List<Lecture> list = new ArrayList<>();
        lectureRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    public void Save(Lecture lecture) {
       lectureRepository.save(lecture);
    }
}
