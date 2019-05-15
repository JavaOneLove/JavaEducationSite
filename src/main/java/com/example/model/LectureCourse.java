package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="lecture_course")
public class LectureCourse {
    @Id
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course", referencedColumnName = "id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture", referencedColumnName = "id")
    private Lecture lecture;

    public LectureCourse(Integer id, Integer select) {
        lecture.setId(id);
        course.setId(select);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Lecture getLeture() {
        return lecture;
    }

    public void setLeture(Lecture lecture) {
        this.lecture = lecture;
    }
}
