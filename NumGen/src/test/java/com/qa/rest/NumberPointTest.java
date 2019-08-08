package com.qa.rest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.RestTemplate;

import com.qa.service.numGeneratorImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(numGenController.class)
@AutoConfigureMockMvc
public class NumberPointTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private numGeneratorImpl service;
	@MockBean
	private RestTemplate restTemplate;
	@MockBean
	private JmsTemplate jmsTemplate; 
	@MockBean
	private JmsListenerContainerFactory<?> myFactory;
	@MockBean
	private MessageConverter jacksonJmsMessageConverter;
	
	@Test
	public void getAll() throws Exception {

		ResultActions res = mockMvc.perform(get("/numgen")).andExpect(content().string(""));
		
		assertEquals("", res.andReturn().getResponse().getContentAsString());
		
	}
}
