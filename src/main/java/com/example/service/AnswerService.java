package com.example.service;

import com.example.model.Answer;
import com.example.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> GetAllAnswer(){
        List<Answer> list = new ArrayList<>();
        answerRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
}
