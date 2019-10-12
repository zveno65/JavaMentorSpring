package ru.plotnikov.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.plotnikov.models.User;
import ru.plotnikov.services.UserService;

import java.util.List;

@RequestMapping("/add")
@Controller
public class AddController {

    private UserService userService;

    @Autowired
    public void setService(UserService service) {
        this.userService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAddUser() {
        return new ModelAndView("add");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postAddUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        List<User> allUsers = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("addName", user.getName());
        modelAndView.addObject("users", allUsers);
        return modelAndView;
    }
}
