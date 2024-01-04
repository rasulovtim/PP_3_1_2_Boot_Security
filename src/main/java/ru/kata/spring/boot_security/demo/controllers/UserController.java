package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

import java.security.Principal;


@Controller
public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user")
    public String showUser(@RequestParam(name = "id", required = false) Long id, Model model, Principal principal) {
        User user;
        if (id != null) {
            user = userServiceImpl.readUser(id);
        } else {
            String username = principal.getName();
            user = userServiceImpl.findByUsername(username);
        }
        model.addAttribute("user", user);
        return "user";
    }

}
