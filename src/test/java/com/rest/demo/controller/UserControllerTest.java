package com.rest.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.rest.demo.TestWebConfig;
import com.rest.demo.service.UserService;

@SpringJUnitWebConfig(TestWebConfig.class)
public class UserControllerTest {
	
	public static MockMvc mockMvc;
	@Mock
	private UserService userService;
	
	

    @BeforeEach
    void setup(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    @Test
	public void getUserTest() throws Exception {
    	String emailId ="trytusar@gmail.com";
		String uri = "/api/user/{emailId}";	
		//MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).param("email", emailId).accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andReturn();
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri, emailId).accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andReturn();
		int status = mvcResult.getResponse().getStatus();
		/**
		 * Success status check 
		 */
		assertEquals(200, status);
		
		//assertTrue(mvcResult.getResponse().getContentType().equals("application/json;charset=UTF-8")); //Content type response
		String content = mvcResult.getResponse().getContentAsString();
		
		/**
		 * Check for content
		 */
		assertTrue(content != null && content.equals(emailId));		
	}
    
    @Test
	public void getUserNotFountTest() throws Exception {
    	String emailId = "test@gmail.com";
		String uri = "/api/user/{emailId}";	
		//MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).param("email", emailId).accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andReturn();
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri, emailId).accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andReturn();
		int status = mvcResult.getResponse().getStatus();
		/**
		 * Success status check 
		 */
		assertEquals(404, status);
		
	}
	
   
    
}
