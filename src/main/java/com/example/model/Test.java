package com.example.model;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private int curse_id;

    public Test(){}

    public Test(String title, int questionCurseId) {
        this.name = title;
        this.curse_id = questionCurseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurse_id() {
        return curse_id;
    }

    public void setCurse_id(int curse_id) {
        this.curse_id = curse_id;
    }

}
