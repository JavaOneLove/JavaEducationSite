package com.example.model;


import javax.persistence.*;

@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String title;
    private String text;
    private String filename;
    private String author;
    private Integer course_id;

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }
    public Lecture(){

    }

    public Lecture(String title, String text, String user, Integer course_id) {
        this.author = user;
        this.text = text;
        this.title = title;
        this.course_id = course_id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
