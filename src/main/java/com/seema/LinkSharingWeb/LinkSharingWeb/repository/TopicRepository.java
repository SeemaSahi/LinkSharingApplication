package com.seema.LinkSharingWeb.LinkSharingWeb.repository;

import com.seema.LinkSharingWeb.LinkSharingWeb.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    static void save(List<Topic> topicLIst) {
    }
}
