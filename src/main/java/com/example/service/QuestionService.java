package com.example.service;

import com.example.model.Question;
import com.example.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> GetAllAnswer(){
        List<Question> list = new ArrayList<>();
        questionRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
}
