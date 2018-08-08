package com.seema.LinkSharingWeb.LinkSharingWeb.controller;

import com.seema.LinkSharingWeb.LinkSharingWeb.domain.Topic;
import com.seema.LinkSharingWeb.LinkSharingWeb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicService topicService;

    @RequestMapping("")
    public ModelAndView getTopicPage(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("topic");
        modelAndView.addObject("topic", new Topic());
        modelAndView.addObject("topicList", topicService.findAll(httpSession));
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Topic topic, HttpSession httpSession) {
        topicService.save(topic, httpSession);
        ModelAndView modelAndView = new ModelAndView("topic");
        modelAndView.addObject("topicList", topicService.findAll(httpSession));
        modelAndView.addObject("topic", new Topic());

        return modelAndView;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("topic");
        modelAndView.addObject("topic", topicService.findById(id));
        modelAndView.addObject("topicList", topicService.findAll(httpSession));
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("topic");
        topicService.delete(id, httpSession);
        modelAndView.addObject("topic", new Topic());
        modelAndView.addObject("topicList", topicService.findAll(httpSession));
        return modelAndView;
    }

}