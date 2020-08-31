package com.socio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socio.model.Registration;



@Repository
public interface RegistrationRepository extends JpaRepository<Registration, String>{

}


