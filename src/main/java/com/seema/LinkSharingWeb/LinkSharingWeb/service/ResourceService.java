package com.seema.LinkSharingWeb.LinkSharingWeb.service;

import com.seema.LinkSharingWeb.LinkSharingWeb.domain.*;
import com.seema.LinkSharingWeb.LinkSharingWeb.repository.ResourceRepositiory;
import com.seema.LinkSharingWeb.LinkSharingWeb.repository.TopicRepository;
import com.seema.LinkSharingWeb.LinkSharingWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ResourceService {
    @Autowired
    ResourceRepositiory resourceRepositiory;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TopicRepository topicRepository;

    public void saveLinkRes(LinkResource linkResource, HttpSession httpSession) {
        if (Objects.isNull(linkResource.getId())) {
            linkResource.setDateCreated(new Date());
        }
        linkResource.setLastUpdated(new Date());
        resourceRepositiory.save(linkResource);

    }

    public void saveDocRes(DocumentResource documentResource, HttpSession httpSession) {
        if (Objects.isNull(documentResource.getId())) {
            documentResource.setDateCreated(new Date());
        }
        documentResource.setLastUpdated(new Date());
        User sessionUser = (User) httpSession.getAttribute("user");
        User dbUser = userRepository.findById(sessionUser.getId()).get();
        Topic topic = topicRepository.findById(documentResource.getTopic().getId()).get();
        documentResource.setTopic(topic);
        List<Resource> resources = topic.getResources();
        resources.add(documentResource);
        topic.setResources(resources);
        topicRepository.save(topic);

    }

    public List<Topic> findAll(HttpSession httpSession) {
        User sessionUser = (User) httpSession.getAttribute("user");
        User dbUser = userRepository.findById(sessionUser.getId()).get();
        List<Topic> topicLIst = dbUser.getTopics();
        return topicLIst;
    }

}
