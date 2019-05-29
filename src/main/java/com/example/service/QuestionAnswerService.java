package com.example.service;

import com.example.model.QuestionAnswer;
import com.example.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionAnswerService {
    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    public List<QuestionAnswer> GetAllAnswerQuestion(){
        List<QuestionAnswer> list = new ArrayList<>();
       questionAnswerRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    public void Save(QuestionAnswer questionAnswer) {
        questionAnswerRepository.save(questionAnswer);
    }
}
