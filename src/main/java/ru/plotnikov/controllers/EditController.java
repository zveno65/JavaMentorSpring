package ru.plotnikov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.plotnikov.form.UserForm;
import ru.plotnikov.models.User;
import ru.plotnikov.services.UserService;

import java.util.List;

@RequestMapping("/edit")
@Controller
public class EditController {

    private UserService userService;

    @Autowired
    public void setService(UserService service) {
        this.userService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getEditUser(@RequestParam(value = "id") String id) {
        User user = userService.getUserById(Long.valueOf(id));
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postEditUser(UserForm userForm, @RequestParam(value = "id") String id) {
        User user = userService.getUserById(Long.valueOf(id));
        user.setName(userForm.getName());
        user.setAge(userForm.getAge());
        userService.updateUser(user);
        List<User> allUsers = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("editName", userForm.getName());
        modelAndView.addObject("users", allUsers);
        return modelAndView;
    }
}
