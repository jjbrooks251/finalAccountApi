package com.qa.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.qa.service.numGenerator;

import static org.mockito.Mockito.doReturn;

import org.junit.Assert;

@RunWith(SpringRunner.class)
public class NumberControllerTest {

	@InjectMocks
	private numGenController controller;
	
	@Mock
	private numGenerator service;

	
	private static final String NUMBER = "123456";
	
	@Test
	public void numberGenerator() {

		doReturn(NUMBER).when(service).ranNum();
		
		Assert.assertEquals(NUMBER, controller.numgen());
	}
	
}
