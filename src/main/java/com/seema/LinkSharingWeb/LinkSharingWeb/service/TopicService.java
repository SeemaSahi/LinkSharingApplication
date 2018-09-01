package com.seema.LinkSharingWeb.LinkSharingWeb.service;

import com.seema.LinkSharingWeb.LinkSharingWeb.domain.Topic;
import com.seema.LinkSharingWeb.LinkSharingWeb.domain.User;
import com.seema.LinkSharingWeb.LinkSharingWeb.exception.RecordNotFoundException;
import com.seema.LinkSharingWeb.LinkSharingWeb.repository.TopicRepository;
import com.seema.LinkSharingWeb.LinkSharingWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;

    @Autowired
    UserRepository userRepository;

    public void save(Topic topic, HttpSession httpSession) {
        if (Objects.isNull(topic.getId())) {
            topic.setCreatedDate(new java.util.Date());
        }
        topic.setLastUpdateDate(new java.util.Date());
        User sessionUser = (User) httpSession.getAttribute("user");
        User dbUser = userRepository.findById(sessionUser.getId()).get();
        List<Topic> topicLIst = dbUser.getTopics();
        topicLIst.removeIf(it -> it.getId() == topic.getId());
        topicLIst.add(topic);
        dbUser.setTopics(topicLIst);
        userRepository.save(dbUser);
    }

    public List<Topic> findAll(HttpSession httpSession) {
        User sessionUser = (User) httpSession.getAttribute("user");
        User dbUser = userRepository.findById(sessionUser.getId()).get();
        List<Topic> topicLIst = dbUser.getTopics();
        return topicLIst;
    }

    public Topic findById(Long id) {
        return topicRepository.findById(id).get();
    }

    public void delete(Long id, HttpSession httpSession) throws Exception {
        User sessionUser = (User) httpSession.getAttribute("user");
        User dbUser = userRepository.findById(sessionUser.getId()).get();
        List<Topic> topicLIst = dbUser.getTopics();

        topicLIst.removeIf(it -> it.getId() == id);
        dbUser.setTopics(topicLIst);
        try {
            topicRepository.deleteById(id);
        } catch (Exception e) {
            throw new RecordNotFoundException("Record not found in db with id" + id);
        }
        userRepository.save(dbUser);
    }

    public void edit(Topic topic, HttpSession httpSession) {
        User sessionUser = (User) httpSession.getAttribute("user");
        User dbUser = userRepository.findById(sessionUser.getId()).get();
        List<Topic> topicLIst = dbUser.getTopics();
        // if(Objects.isNull(topicLIst.getId()))
        topicLIst.add(topic);
        dbUser.setTopics(topicLIst);
        userRepository.save(dbUser);
    }

}


