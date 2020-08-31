package com.socio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socio.model.Club;



@Repository
public interface ClubRepository extends JpaRepository<Club, Long>{

}


