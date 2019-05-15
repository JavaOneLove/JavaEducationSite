package com.example.repository;

import com.example.model.Lecture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LectureRepository extends CrudRepository<Lecture, Integer> {
}
