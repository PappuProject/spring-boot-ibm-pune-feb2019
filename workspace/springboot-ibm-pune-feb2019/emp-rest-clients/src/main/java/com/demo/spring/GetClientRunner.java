package com.demo.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetClientRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		RestTemplate rt=new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity req=new HttpEntity<>(headers);
		ResponseEntity<String> resp=rt.exchange("http://localhost:8081/emp/find/104", 
				HttpMethod.GET, req, String.class);
		
		System.out.println(resp.getBody());
	}

}
