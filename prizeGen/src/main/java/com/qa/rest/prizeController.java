package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.service.prizeService;

@RestController
@RequestMapping("/prize")
public class prizeController {
	
	private prizeService service;

	public prizeController(prizeService service) {
		this.service = service;
	}
	
	@GetMapping("/get/{accNo}")
	public String prize(@PathVariable String accNo) {
		//String num = rest.getForObject("http://localhost:8082/numgen", String.class);
		
		return service.prizes(accNo);
	}

}
