package com.rest.demo.repository;

import org.springframework.stereotype.Service;

@Service
public class UserRepository {

	public String findUserByEmail(String emailId) throws Exception{
		if(!emailId.equals("trytusar@gmail.com"))
			return null;
		return emailId;
	}

	
	

}
