package com.example.controller;

import com.example.model.Role;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addNewUser(User user, Map<String,Object> model){
        User UserFromDB = userRepository.findByUsername(user.getUsername());

        if(UserFromDB != null){
            model.put("message","Пользователь с таким именем уже существует!");
            return "registration";
        }
        else {
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepository.save(user);
        }
    return "redirect:/login";
    }
}
