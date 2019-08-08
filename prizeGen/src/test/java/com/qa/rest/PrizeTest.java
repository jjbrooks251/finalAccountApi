package com.qa.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.service.prizeService;

import org.junit.Assert;

@RunWith(SpringRunner.class)
public class PrizeTest {

	@InjectMocks
	private prizeController controller;
	
	@Mock
	private prizeService service;
	
	@Test
	public void prizeGenerator() {
		Mockito.when(service.prizes("b123456")).thenReturn("$50");
		Assert.assertEquals("$50", controller.prize("b123456"));
		Mockito.verify(service).prizes("b123456");
	}
	
}
