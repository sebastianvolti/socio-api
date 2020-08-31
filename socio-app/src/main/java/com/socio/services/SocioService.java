package com.socio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socio.model.Registration;

@Component
public class SocioService {

	@Autowired
	private PersistenceService persistanceService;

	private static final int LOGIN_OK = 1;
	private static final int LOGIN_FAIL = 0;

	/*
	 * GET OPERATIONS
	 */

	public int loginRequest(String email, String pass) throws Exception {
		Registration registration = persistanceService.loginRequest(email);
		int result = LOGIN_FAIL;
		if ( (registration != null) &&  registration.getPass().equals(pass)) {
			result = LOGIN_OK;
		}
		return result;
	}


	/*
	 * INSERT OPERATIONS
	 */

	public void insertRegistration(String email, String pass, String cid, String name, String lastName) throws Exception   {
		persistanceService.insertRegistration(email, pass, cid, name, lastName);
	}

	public void insertClub(Long clubId, String clubName, String clubDir, Long clubAmmount) throws Exception   {
		persistanceService.insertClub(clubId, clubName, clubDir, clubAmmount);
	}

	public void insertSubscription(String email, Long clubId, String tokenAccount, String paymentId) throws Exception   {
		Long subsAmmount = getSubscriptionAmmount(clubId);
		if (subsAmmount > 0) {
			persistanceService.insertSubscription(email, clubId, tokenAccount, subsAmmount, paymentId);
		}
		else {
			throw new RuntimeException("Invalid clubAmmount for clubId =" + clubId);
		}
	}

	/*
	 * UPDATE OPERATIONS
	 */



	/*
	 * DELETE OPERATIONS
	 */



	/*
	 * OTHERS OPERATIONS
	 */

	private Long getSubscriptionAmmount(Long clubId) {
		return persistanceService.getClubAmmount(clubId);
	}

}
