package com.qa.rest;

import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.service.charGenService;

import org.junit.Assert;

@RunWith(SpringRunner.class)
public class charGenTest {
	@InjectMocks
	private charGenController controller;
	
	@Mock
	private charGenService service;
	
	private static final String lett = "b";
	
	@Test
	public void charGenerator() {
		doReturn(lett).when(service).charGen();
		Assert.assertEquals(lett, controller.charGen());
		
	}

}
