package com.rest.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rest.demo.repository.UserRepository;
import com.rest.demo.service.impl.UserServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService = new UserServiceImpl();
	/*
	@Test
	public void test2 () throws Exception {
		Exception assertThrows = Assertions.assertThrows(Exception.class,
				() -> { userService.getUserData(""); });
		System.out.println(assertThrows);
		//assertEquals(HttpStatus.NOT_FOUND, assertThrows.get);
	}
	*/
	@Test
	public void verifyEqual() throws Exception {
		
		String emailId ="trytusar@gmail.com";
		String userData = userService.getUserData(emailId);
		assertTrue(userData.equals(emailId));
	}

	@Test
	public void verifyNotFound() throws Exception {
		String emailId ="trytusar@gmail.com";
		
		when(userRepository.findUserByEmail(emailId)).thenReturn(emailId);
		
		String userData = userService.getUserData(emailId);
		
		assertEquals(userData, emailId);
	}
	
	@Test
	public void verifyNotFound2() throws Exception {
		String emailId ="test@gmail.com";
		
		//when(userRepository.findUserByEmail(emailId)).thenReturn(emailId);
		
		String userData = userService.getUserData(emailId);
		
		assertEquals(userData, null);
	}
	

}
