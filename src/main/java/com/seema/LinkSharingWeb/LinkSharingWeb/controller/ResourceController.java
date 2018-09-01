package com.seema.LinkSharingWeb.LinkSharingWeb.controller;

import com.seema.LinkSharingWeb.LinkSharingWeb.domain.DocumentResource;
import com.seema.LinkSharingWeb.LinkSharingWeb.domain.LinkResource;
import com.seema.LinkSharingWeb.LinkSharingWeb.domain.Topic;
import com.seema.LinkSharingWeb.LinkSharingWeb.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    @RequestMapping("/linkedResource")
    public ModelAndView getLinkResourceView() {
        ModelAndView modelAndView = new ModelAndView("linkedResource");
        modelAndView.addObject("linkedResource", new LinkResource());
        return modelAndView;
    }

    @RequestMapping("/documentResource")
    public ModelAndView getDocResourceView(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("documentResource");
        modelAndView.addObject("documentResource", new DocumentResource());
        modelAndView.addObject("topicList", resourceService.findAll(httpSession));
        return modelAndView;
    }

    @RequestMapping(value = "/saveLinkRes", method = RequestMethod.POST)
    public ModelAndView saveLinkRes(@ModelAttribute LinkResource linkResource, Topic topic, HttpSession httpSession) {
        resourceService.saveLinkRes(linkResource, httpSession);
        ModelAndView modelAndView = new ModelAndView("linkedResource");
        modelAndView.addObject("linkedResource", new LinkResource());
        return modelAndView;
    }


    @RequestMapping(value = "/saveDocRes", method = RequestMethod.POST)
    public ModelAndView saveDocRes(@ModelAttribute DocumentResource documentResource, HttpSession httpSession) {
        resourceService.saveDocRes(documentResource, httpSession);
        ModelAndView modelAndView = new ModelAndView("documentResource");
        modelAndView.addObject("topicList", resourceService.findAll(httpSession));
        modelAndView.addObject("documentResource", new LinkResource());
        return modelAndView;
    }
}


