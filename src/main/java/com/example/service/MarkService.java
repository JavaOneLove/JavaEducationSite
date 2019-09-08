package com.example.service;

import com.example.model.Mark;
import com.example.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkService {
    @Autowired
    private MarkRepository markRepository;
    public List<Mark> GetAllMark() {
        List<Mark> list = new ArrayList<>();
        markRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    public void Save(Mark mark) {
        markRepository.save(mark);
    }
}
