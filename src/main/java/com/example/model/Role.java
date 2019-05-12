package com.example.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, TEACHER, STUDENT, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
