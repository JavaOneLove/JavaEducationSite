package com.example.model;

import javax.persistence.*;

@Entity
public class QuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String answer;
    private String question;

    @ManyToOne
    private Test test;

    public QuestionAnswer(String answer, String question,Test test) {
        this.answer = answer;
        this.question = question;
        this.test = test;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
