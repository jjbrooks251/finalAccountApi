package com.qa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrizeTest {
	
	@InjectMocks
	private prizeServiceImpl service;
	
	@Test
	public void generator() { 
		Assert.assertEquals("Win $50", service.prizes("b123456"));
	}

}
