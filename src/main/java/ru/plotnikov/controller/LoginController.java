package ru.plotnikov.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.plotnikov.model.Role;
import ru.plotnikov.model.User;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping(value = "/performLogin", method = RequestMethod.POST)
    public String performLogin(Model model, HttpSession session) {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication.getPrincipal() instanceof User))
            throw new IllegalArgumentException("Principal can't be null");

        User user = (User) authentication.getPrincipal();

        String viewPath;

        if (user.getRoles().contains(new Role("ADMIN")))
            viewPath = "redirect:/admin";
        else {
            viewPath = "redirect:/edit";
            model.addAttribute("id", user.getId());
            session.setAttribute("id", user.getId());
        }

        return viewPath;
    }

    @RequestMapping(value = "/failedLogin", method = RequestMethod.GET)
    public String ErrorLogin(Model model) {
        model.addAttribute("error", "true");
        return "redirect:/edit";
    }
}