package ru.plotnikov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.plotnikov.exception.UserAccountException;
import ru.plotnikov.model.User;
import ru.plotnikov.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/registration")
@Controller
public class RegistrationController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView registrationForm() {
        return new ModelAndView("registration");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(Model model, @ModelAttribute("user") @Valid User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.addUser(user);
        }
        catch (UserAccountException e) {
//            ModelAndView modelAndView = new ModelAndView("registration");
            model.addAttribute("user", user);
            model.addAttribute("exception", "This account is already exist");
            return "redirect:/registration";
        }
        List<User> allUsers = userService.getAllUsers();
//        ModelAndView modelAndView = new ModelAndView("list");
        model.addAttribute("addName", user.getName());
        model.addAttribute("users", allUsers);
        return "redirect:/admin";
    }
}
