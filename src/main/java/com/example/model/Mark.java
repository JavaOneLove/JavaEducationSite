package com.example.model;

import javax.persistence.*;

@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int value;


    public int getIdtest() {
        return Idtest;
    }

    public void setIdtest(int idtest) {
        Idtest = idtest;
    }

    private int Idtest;
    @ManyToOne
    private User user;

    public int getId() {
        return id;
    }

    public Mark() {
    }

    public Mark(int value,User user,Test test,int Idtest) {
        this.value = value;
        this.test = test;
        this.user = user;
        this.Idtest = Idtest;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @ManyToOne
    private Test test;
}
