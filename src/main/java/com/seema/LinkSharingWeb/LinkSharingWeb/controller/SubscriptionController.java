package com.seema.LinkSharingWeb.LinkSharingWeb.controller;

import com.seema.LinkSharingWeb.LinkSharingWeb.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Subscription")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;
}
