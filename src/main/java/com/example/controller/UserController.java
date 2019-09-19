package com.example.controller;


import com.example.model.Course;
import com.example.model.Mark;
import com.example.model.Role;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.CourseService;
import com.example.service.MarkService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
   private UserRepository userRepository;
    @Autowired
    private UserService userSevice;
    @Autowired
    private MarkService markService;
    @Autowired
    private CourseService courseService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("profile")
    public String getProfile(Model model,Map<String,Object> models, @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        List<Mark> marks = markService.GetAllMark();
        models.put("marks",marks);

        return "profile";
    }

    @PostMapping("EditInfo")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String username
    ) {
        userSevice.updateProfile(user, password, email, username);

        return "redirect:/home";
    }
    @PostMapping("profile/AddCourse")
    public String AddCourse(@RequestParam(value = "coursename") String coursename){
        Course course = new Course(coursename);
        courseService.Save(course);
        return "redirect:/home";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userSevice.Save(user);

        return "redirect:/user";
    }
}
