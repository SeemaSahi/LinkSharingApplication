package com.seema.LinkSharingWeb.LinkSharingWeb.domain;

import com.seema.LinkSharingWeb.LinkSharingWeb.util.Seriousness;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Subscription {

    @Id
    private Long id;
    @OneToOne
    private Topic topic;
    @OneToOne
    private User user;
    private Date dateCreated;
    @Enumerated(EnumType.STRING)
    private Seriousness seriousness;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Seriousness getSeriousness() {
        return seriousness;
    }

    public void setSeriousness(Seriousness seriousness) {
        this.seriousness = seriousness;
    }
}
