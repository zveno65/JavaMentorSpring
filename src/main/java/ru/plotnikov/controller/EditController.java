package ru.plotnikov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.plotnikov.model.User;
import ru.plotnikov.service.UserService;

import java.util.List;

@RequestMapping("/edit")
@Controller
public class EditController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getEditUser(@RequestParam(value = "id") String id) {
        User user = userService.getUserById(Long.valueOf(id));
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postEditUser(@ModelAttribute("user") User editUser, @RequestParam(value = "id") String id) {
        User user = userService.getUserById(Long.valueOf(id));
        user.setName(editUser.getName());
        user.setAge(editUser.getAge());
        userService.updateUser(user);
        List<User> allUsers = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("editName", editUser.getName());
        modelAndView.addObject("users", allUsers);
        return modelAndView;
    }
}
