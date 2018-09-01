package com.seema.LinkSharingWeb.LinkSharingWeb.controller;

import com.seema.LinkSharingWeb.LinkSharingWeb.domain.User;
import com.seema.LinkSharingWeb.LinkSharingWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView homePage() {
        return new ModelAndView("home");
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
        // return new ModelAndView("welcome", "firstName", userService.getClass() );

    }

    @RequestMapping("/signup")
    public ModelAndView getPage() {
        ModelAndView modelAndView = new ModelAndView("signup");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("signup");
            modelAndView.addObject("user", user);
            return modelAndView;
        } else {
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;

        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        httpSession.invalidate();
        return "login";
    }
}
