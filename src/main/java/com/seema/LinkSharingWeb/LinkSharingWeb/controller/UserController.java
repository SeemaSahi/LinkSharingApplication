package com.seema.LinkSharingWeb.LinkSharingWeb.controller;

import com.seema.LinkSharingWeb.LinkSharingWeb.domain.User;
import com.seema.LinkSharingWeb.LinkSharingWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping("/loginCheck")
    public ModelAndView validate(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession httpSession) {
        ModelAndView modelAndView = null;
        if (email != null && password != null) {
            User user = userService.validateLogin(email, password);
            if (user != null) {
                httpSession.setAttribute("user", user);
                modelAndView = new ModelAndView("home");
            } else
                modelAndView = new ModelAndView("login");
        } else
            modelAndView = new ModelAndView("login");

        return modelAndView;

    }

    @RequestMapping("/signup")
    public ModelAndView getPage() {
        ModelAndView modelAndView = new ModelAndView("signup");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user) {
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        httpSession.invalidate();
        return "login";
    }
}
