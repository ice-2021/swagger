package com.ice.helloworld.ms.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import com.ice.helloworld.ms.controller.HelloWorldController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerTest {

	@Autowired
	private HelloWorldController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetGreeting() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/helloworld/getGreeting?name=smith",
				String.class)).contains("smith");
	}

	@Test
	public void testShowGreeting() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> request = new HttpEntity<String>("{\"name\":\"smith\"}", headers);

		assertThat(restTemplate
				.postForObject("http://localhost:" + port + "/helloworld/showGreeting", request, String.class)
				.contains("smith"));

	}
}
