package com.example.repository;

import com.example.model.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Integer> {
}
