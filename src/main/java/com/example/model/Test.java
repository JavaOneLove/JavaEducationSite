package com.example.model;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

    @ManyToOne
    private QuestionAnswer questionAnswer;
}
