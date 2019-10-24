package ru.plotnikov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.plotnikov.model.User;
import ru.plotnikov.service.UserService;

@RequestMapping("/delete")
@Controller
public class DeleteController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String deleteUser(@RequestParam(value = "id") String id) {
        User user = userService.getUserById(Long.valueOf(id));
        userService.deleteUser(user);
        return "redirect:/admin";
    }
}