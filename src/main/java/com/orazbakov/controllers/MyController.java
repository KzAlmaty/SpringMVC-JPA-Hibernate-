package com.orazbakov.controllers;

import com.orazbakov.model.User;
import com.orazbakov.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    private final UserService userService;

    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getIndex(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "index";
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "user-info";

    }

    @GetMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/";
    }


    @GetMapping(value = "/updateInfo/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "user-info";

    }

    @GetMapping(value = "/deleteInfo/{id}")
    public String deleteInfo(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


}