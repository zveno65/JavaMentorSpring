package ru.plotnikov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.plotnikov.exception.UserAccountException;
import ru.plotnikov.model.Role;
import ru.plotnikov.model.User;
import ru.plotnikov.service.UserService;

import javax.validation.Valid;
import java.util.*;

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
    public ModelAndView registerUser(Model model, @ModelAttribute("user") @Valid User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.addUser(user);
        }
        catch (UserAccountException e) {
            user.setPassword("");
            ModelAndView modelAndView = new ModelAndView("registration");
            modelAndView.addObject("exception", "This account is already exist");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        try {
            UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        }
        catch (Exception e) {
            return new ModelAndView("login");
        }
        return new ModelAndView("redirect:/admin");
    }
}
