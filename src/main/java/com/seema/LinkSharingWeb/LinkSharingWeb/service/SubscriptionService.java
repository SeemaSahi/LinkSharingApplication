package com.seema.LinkSharingWeb.LinkSharingWeb.service;

import com.seema.LinkSharingWeb.LinkSharingWeb.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionRepository subscriptionRepository;
}
