package com.qa.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import com.qa.entities.Account;
import com.qa.rest.AccountController;
import com.qa.service.AccountServiceImpl;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {

	@InjectMocks
	private AccountController controller;
	
	@Mock
	private AccountServiceImpl service;
	
	@Mock
	private RestTemplate rest;
	
	@Mock
	private JmsTemplate jmsTemplate; 
	
	private static final Account acc1 = new Account(1, "abc123456", "Josh", "brooks", "jjb@qa.com", "$50");
	private static final Account acc2 = new Account(2, "def123456", "krystal", "ryan", "diddle@qa.com", "$100");
	
	
	@Test
	public void getAllAccounts() {
		List<Account> Mock_List = new ArrayList<>();
		Mock_List.add(acc1);
		Mock_List.add(acc2);
		Mockito.when(controller.getAllAccounts()).thenReturn(Mock_List);
		Assert.assertEquals(Mock_List, controller.getAllAccounts());
		Mockito.verify(service).findAll();
	}
	
	@Test
	public void getJosh() {
		List<Account> Mock_List = new ArrayList<>();
		Mock_List.add(acc1);
		Mock_List.add(acc2);
		Mockito.when(service.findName("Josh")).thenReturn(acc1);
		Assert.assertEquals(acc1, controller.getOneAccount("Josh"));
		Mockito.verify(service).findName("Josh");
	}
	
	@Test
	public void createAccount() {
		
		ResponseEntity<String> number = new ResponseEntity<String>("123456", HttpStatus.OK);
		ResponseEntity<String> lett = new ResponseEntity<String>("b", HttpStatus.OK);
		ResponseEntity<String> prize = new ResponseEntity<String>("$50", HttpStatus.OK);
		
		Mockito.when(rest.getForObject("http://localhost/8081/chargen", String.class)).thenReturn(lett.getBody());
		Mockito.when(rest.exchange("http://localhost/8082/numgen", HttpMethod.GET, null, String.class)).thenReturn(number);
		Mockito.when(rest.exchange("http://localhost/8083/prize/get", HttpMethod.GET, null, String.class)).thenReturn(prize);
		
		Mockito.when(service.createAccount(acc1)).thenReturn(acc1);
		Assert.assertEquals(acc1, controller.createAccount(acc1).getBody());
		Mockito.verify(service).createAccount(acc1);
	}
	
	@Test
	public void updateAccount() {
		Mockito.when(service.updateAccount(acc1)).thenReturn("Account Updated");
		Assert.assertEquals("Account Updated", controller.updateAccount(acc1));
		Mockito.verify(service).updateAccount(acc1);
	}
	
	@Test
	public void deleteAccount() {
		Mockito.when(service.deleteAccount(1)).thenReturn("Account Deleted");
		Assert.assertEquals("Account Deleted", controller.deleteAccount(1));
		Mockito.verify(service).deleteAccount(1);
	}
}
