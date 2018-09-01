package com.seema.LinkSharingWeb.LinkSharingWeb.repository;

import com.seema.LinkSharingWeb.LinkSharingWeb.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
