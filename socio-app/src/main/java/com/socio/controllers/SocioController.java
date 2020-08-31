package com.socio.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socio.services.SocioService;

@RestController
public class SocioController {

	private static final Logger logger = Logger.getLogger(SocioController.class.getName());
	private static final int LOGIN_OK = 1;
	private static final String PING_MESSAGE = "SocioController at your service";
	private static final String REGISTRATION_MESSAGE = "Registration Succesfully";
	private static final String CLUB_REGISTRATION_MESSAGE = "Club Registration Succesfully";
	private static final String NEW_SUBSCRIPTION_MESSAGE = "New Subscription Succesfully";

	@Autowired
	private SocioService socioService;


	/*
	 * GET OPERATIONS
	 */

	@GetMapping("public/ping")
	public ResponseEntity<Object> ping() {
		logger.log(Level.INFO, "[ping] ping method");
		return new ResponseEntity<>(PING_MESSAGE, HttpStatus.OK);
	}


	@GetMapping("login/request")
	public ResponseEntity<Object> loginRequest(@RequestParam String email, @RequestParam String pass) {
		try {
			if (email == null || email.length() == 0) {
				throw new BadRequestException("Parameter email cannot be empty");
			}
			if (pass == null || pass.length() == 0) {
				throw new BadRequestException("Parameter pass cannot be empty");
			}
			int result = socioService.loginRequest(email, pass);
			if (result == LOGIN_OK) {
				logger.log(Level.INFO, "[loginRequest] loginRequest OK");
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		} catch (BadRequestException e) {
			logger.log(Level.WARNING, "loginRequest", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			logger.log(Level.SEVERE, "login/request", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	/*
	 * INSERT OPERATIONS
	 */

	@PostMapping("process/registration")
	public ResponseEntity<Object> processRegistration(@RequestParam String email, @RequestParam String pass, @RequestParam String cid, @RequestParam String name, @RequestParam String lastName) {
		try {
			if (email == null || email.length() == 0) {
				throw new BadRequestException("Parameter email cannot be empty");
			}
			if (pass == null || pass.length() == 0) {
				throw new BadRequestException("Parameter pass cannot be empty");
			}
			if (cid == null || cid.length() == 0) {
				throw new BadRequestException("Parameter cid cannot be empty");
			}
			if (name == null || name.length() == 0) {
				throw new BadRequestException("Parameter name cannot be empty");
			}
			if (lastName == null || lastName.length() == 0) {
				throw new BadRequestException("Parameter lastName cannot be empty");
			}
			socioService.insertRegistration(email, pass, cid, name, lastName);
			logger.log(Level.INFO, "[processRegistration] processRegistration OK");
			return new ResponseEntity<>(REGISTRATION_MESSAGE, HttpStatus.OK);
		} catch (BadRequestException e) {
			logger.log(Level.WARNING, "processRegistration", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			logger.log(Level.SEVERE, "processRegistration", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("process/club")
	public ResponseEntity<Object> processClub(@RequestParam Long clubId, @RequestParam String clubName, @RequestParam String clubDir, @RequestParam Long clubAmmount) {
		try {
			if (clubId == null || clubId <= 0) {
				throw new BadRequestException("Parameter clubId cannot be empty");
			}
			if (clubName == null || clubName.length() == 0) {
				throw new BadRequestException("Parameter clubName cannot be empty");
			}
			if (clubDir == null || clubDir.length() == 0) {
				throw new BadRequestException("Parameter clubDir cannot be empty");
			}
			if (clubAmmount == null || clubAmmount <= 0) {
				throw new BadRequestException("Parameter clubAmmount cannot be empty");
			}
			socioService.insertClub(clubId, clubName, clubDir, clubAmmount);
			logger.log(Level.INFO, "[processClub] processClub OK");
			return new ResponseEntity<>(CLUB_REGISTRATION_MESSAGE, HttpStatus.OK);
		} catch (BadRequestException e) {
			logger.log(Level.WARNING, "processClub", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			logger.log(Level.SEVERE, "processClub", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@PostMapping("process/subscription")
	public ResponseEntity<Object> processSubscription(@RequestParam String email, @RequestParam Long clubId, @RequestParam String tokenAccount,  @RequestParam String paymentId) {
		try {
			if (email == null || email.length() == 0) {
				throw new BadRequestException("Parameter email cannot be empty");
			}
			if (clubId == null || clubId <= 0) {
				throw new BadRequestException("Parameter club_id cannot be empty");
			}
			if (tokenAccount == null || tokenAccount.length() == 0) {
				throw new BadRequestException("Parameter tokenAccount cannot be empty");
			}
			if (paymentId == null || paymentId.length() == 0) {
				throw new BadRequestException("Parameter paymentId cannot be empty");
			}
			socioService.insertSubscription(email, clubId, tokenAccount, paymentId);
			logger.log(Level.INFO, "[processSubscription] processSubscription OK");
			return new ResponseEntity<>(NEW_SUBSCRIPTION_MESSAGE, HttpStatus.OK);
		} catch (BadRequestException e) {
			logger.log(Level.WARNING, "processSubscription", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			logger.log(Level.SEVERE, "processSubscription", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/*
	 * UPDATE OPERATIONS
	 */


	/*
	 * DELETE OPERATIONS
	 */


}
