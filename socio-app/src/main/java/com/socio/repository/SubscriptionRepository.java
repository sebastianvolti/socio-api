package com.socio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socio.model.Subscription;



@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionId>{

}


