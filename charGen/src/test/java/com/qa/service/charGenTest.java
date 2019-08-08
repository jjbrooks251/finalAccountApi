package com.qa.service;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class charGenTest {

	@InjectMocks
	private charGenServiceImpl service;
	
	@Test
	public void genTest() {
		String pattern = "[abc]";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(service.charGen());		
		
		assertEquals(true, m.matches());
	}
	
}
