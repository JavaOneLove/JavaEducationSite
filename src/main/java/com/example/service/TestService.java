package com.example.service;

import com.example.model.Test;
import com.example.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    public List<Test> GetAllTest() {
        List<Test> list = new ArrayList<>();
        testRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    public void Save(Test test) {
        testRepository.save(test);
    }
    public Test GetTestById(int id){
        Optional<Test> optionalTest = testRepository.findById(id);
        return optionalTest.get();
    }
}
