package ru.plotnikov.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.plotnikov.models.User;
import ru.plotnikov.services.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class ListController {
    private UserService userService;

    @Autowired
    public void setService(UserService service) {
        this.userService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllUsers(@RequestParam(value = "first_name", required = false) String firstName) {
        List<User> users = null;
        users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
