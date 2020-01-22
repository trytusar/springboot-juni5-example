package com.rest.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.repository.UserRepository;
import com.rest.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	/**
	 * @Desciption :
	 * @param :
	 * @throws ApplicationSystemException
	 * @Return :
	 * 
	 */
	public String getUserData(String emailId){
		try {
			if(emailId == null)
				throw new NullPointerException("Null data");
			
			String user = userRepository.findUserByEmail(emailId);
			
			return user;
			//....set others
		} catch (Exception exception) {
			log.error(exception.getMessage(), exception);
			return null;
		}
		
	}

	


}
