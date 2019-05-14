package com.example.service;

import com.example.model.Lecture;
import com.example.repository.LectureRepository;
import com.example.repository.iLectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectureService implements iLectureService {
    @Autowired
    private LectureRepository lectureRepository;
    @Override
    public List<Lecture> GetAllLecture() {
        List<Lecture> list = new ArrayList<>();
        lectureRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
}
