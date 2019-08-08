package com.qa.rest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.qa.entities.Account;
import com.qa.rest.AccountController;
import com.qa.service.AccountServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
public class AccountPointTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private AccountServiceImpl service;
	@MockBean
	private RestTemplate restTemplate;
	@MockBean
	private JmsTemplate jmsTemplate; 
	@MockBean
	private JmsListenerContainerFactory<?> myFactory;
	@MockBean
	private MessageConverter jacksonJmsMessageConverter;
	
	private static final Account acc1 = new Account(1, "abc123456", "Josh", "brooks", "jjb@qa.com", "$100");
	private static final String acc1_ob = "{\"aId\":1,\"accNo\":\"abc123456\",\"firstName\":\"Josh\",\"lastName\":\"brooks\",\"email\":\"jjb@qa.com\",\"prize\":\"$100\"}";
	private static final Account acc2 = new Account(2, "def123456", "krystal", "ryan", "diddle@qa.com", "$50");
	private static final String acc2_ob = "{\"aId\":2,\"accNo\":\"def123456\",\"firstName\":\"krystal\",\"lastName\":\"ryan\",\"email\":\"diddle@qa.com\",\"prize\":\"$50\"}";
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	
	@Test
	public void getAll() throws Exception {
		List<Account> Mock_List = new ArrayList<>();
		Mock_List.add(acc1);
		Mock_List.add(acc2);
		when(service.findAll()).thenReturn(Mock_List);

		ResultActions res = mockMvc.perform(get("/accounts/getAll")).andExpect(content().string(containsString("Josh")));
		
		assertEquals("[" + acc1_ob + "," + acc2_ob + "]", res.andReturn().getResponse().getContentAsString());
		
	}

	
	@Test
	public void create() throws Exception {
		String account = OBJECT_MAPPER.writeValueAsString(acc1);

		doReturn(acc1).when(service).createAccount(acc1);

		mockMvc.perform(MockMvcRequestBuilders
				.post("/accounts/createAccount")
				.contentType(MediaType.APPLICATION_JSON)
				.content(account)).andExpect(status().isCreated())
		        .andDo(print())
		        .andReturn();
	}

	
	@Test
	public void update() throws Exception {
		
		String account = OBJECT_MAPPER.writeValueAsString(acc1);

		//doReturn("Account Updated").when(service).updateAccount(acc1);

		//Mockito.when(service.updateAccount(acc1)).thenReturn("Account Updated");

		when(service.updateAccount(acc1)).thenReturn("Account Updated");

		
		MvcResult res = mockMvc.perform(MockMvcRequestBuilders
				.put("/accounts/updateAccount")
				.contentType(MediaType.APPLICATION_JSON)
				.content(account)).andExpect(status().isOk())
		        .andDo(print())
		        .andReturn();
		
		String body = res.getResponse().getContentAsString();
		
		assertEquals("", body);
	}
	
	
	@Test
	public void delete() throws Exception {
		String account = OBJECT_MAPPER.writeValueAsString(1);

		doReturn("Account Deleted").when(service).deleteAccount(1);

		MvcResult res = mockMvc.perform(MockMvcRequestBuilders
				.delete("/accounts/deleteAccount")
				.contentType(MediaType.APPLICATION_JSON)
				.content(account)).andExpect(status().isOk())
				.andDo(print())
		        .andReturn();
		
		assertEquals("Account Deleted", res.getResponse().getContentAsString());
	}

}
