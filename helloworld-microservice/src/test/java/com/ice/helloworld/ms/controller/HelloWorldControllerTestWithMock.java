package com.ice.helloworld.ms.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTestWithMock {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetGreeting() throws Exception {
		this.mockMvc.perform(get("/helloworld/getGreeting?name=smith")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("smith")));
	}

	@Test
	public void testShowGreeting() throws Exception {
		this.mockMvc
				.perform(post("/helloworld/showGreeting").content("{\"name\":\"smith\"}")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("smith")));
	}
}
