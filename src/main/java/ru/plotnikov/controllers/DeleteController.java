package ru.plotnikov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.plotnikov.models.User;
import ru.plotnikov.services.UserService;

@RequestMapping("/delete")
@Controller
public class DeleteController {

    private UserService userService;

    @Autowired
    public void setService(UserService service) {
        this.userService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String deleteUser(@RequestParam(value = "id") String id) {
        User user = userService.getUserById(Long.valueOf(id));
        userService.deleteUser(user);
        return "redirect:/";
    }
}