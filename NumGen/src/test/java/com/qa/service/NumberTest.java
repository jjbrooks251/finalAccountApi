package com.qa.service;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberTest {

	@InjectMocks
	private numGeneratorImpl service;
	
	@Test
	public void generator() {
		
		
		String pattern = "\\d{6}";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(service.ranNum());		
		
		assertEquals(true, m.matches());
	}
	
}
