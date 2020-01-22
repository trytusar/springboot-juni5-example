package com.rest.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.service.UserService;
import com.rest.demo.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserService userService;

	private static final String USER_URL = "/user";
	private static final String GET_ALL_USERS = "/users";
	
	@RequestMapping(value = USER_URL +"/{emailId}", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> getUser(@PathVariable("emailId") String email) {
		String response  = null;
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			response = userService.getUserData(email);
			if(response == null)
				httpStatus = HttpStatus.NOT_FOUND;
		} catch (Exception exception) {
			log.error("Exception in getUser()", exception);
			response =  "failed";
		}
		return new ResponseEntity<String>(response, httpStatus);
	}

	

}
