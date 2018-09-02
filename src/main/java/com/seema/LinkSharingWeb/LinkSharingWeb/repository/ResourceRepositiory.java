package com.seema.LinkSharingWeb.LinkSharingWeb.repository;

import com.seema.LinkSharingWeb.LinkSharingWeb.domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ResourceRepositiory extends JpaRepository<Resource, Long> {
}
