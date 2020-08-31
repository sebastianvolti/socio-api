package com.socio.services;

import java.sql.Timestamp;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socio.model.Club;
import com.socio.model.Registration;
import com.socio.model.Subscription;
import com.socio.repository.ClubRepository;
import com.socio.repository.RegistrationRepository;
import com.socio.repository.SubscriptionRepository;



@Component
public class PersistenceService {

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private ClubRepository clubRepository;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	private static final Logger logger = Logger.getLogger(PersistenceService.class.getName());

	/*
	 * GET OPERATIONS
	 */

	@Transactional
	public Registration loginRequest(String email) {
		Registration registration = null;
		if(registrationRepository.existsById(email)) {
			registration = registrationRepository.getOne(email);
		}
		return registration;
	}


	@Transactional
	public Long getClubAmmount(Long clubId) {
		Club club = null;
		if(clubRepository.existsById(clubId)) {
			club = clubRepository.getOne(clubId);
		}
		if (club != null) {
			return club.getClub_ammount();
		}
		return (long) 0;
	}



	/*
	 * INSERT OPERATIONS
	 */

	@Transactional
	public void insertRegistration(String email, String pass, String cid, String name, String lastName)  {
		Registration registration = new Registration();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		registration.setEmail(email);
		registration.setPass(pass);
		registration.setCid(cid);
		registration.setName(name);
		registration.setLast_name(lastName);
		registration.setTiempo(timestamp);
		registration = registrationRepository.save(registration);
	}

	@Transactional
	public void insertClub(Long clubId, String clubName, String clubDir, Long clubAmmount)  {
		Club club = new Club();
		club.setClub_id(clubId);
		club.setClub_name(clubName);
		club.setClub_dir(clubDir);
		club.setClub_ammount(clubAmmount);
		club = clubRepository.save(club);
	}

	@Transactional
	public void insertSubscription(String email, Long club_id, String tokenAccount, Long subsAmmount, String paymentId)  {
		Subscription subscription = new Subscription();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		subscription.setEmail(email);
		subscription.setClub_id(club_id);
		subscription.setToken_account(tokenAccount);
		subscription.setPayment_id(paymentId);
		subscription.setSubs_ammount(subsAmmount);
		subscription.setTiempo(timestamp);
		subscription = subscriptionRepository.save(subscription);
	}



	/*
	 * UPDATE OPERATIONS
	 */



	/*
	 * DELETE OPERATIONS
	 */


}
