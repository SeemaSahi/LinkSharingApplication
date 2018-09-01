package com.seema.LinkSharingWeb.LinkSharingWeb.domain;

import com.seema.LinkSharingWeb.LinkSharingWeb.util.Visibility;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String name;
    private Date createdby;
    private Date createdDate;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Resource> resources = new ArrayList<>();

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Date createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    private Date lastUpdateDate;

    public Long getId() {
        return id;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
