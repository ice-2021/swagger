package com.ice.helloworld.ms.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/helloworld/getGreeting")
	public ResponseEntity<String> getGreeting(@RequestParam("name") String name) {
		return new ResponseEntity<String>("Welcome to ICE 2021 " + name, HttpStatus.OK);
	}

	@PostMapping("/helloworld/showGreeting")
	public ResponseEntity<String> showGreeting(@RequestBody HashMap<String, String> requestBody) {
		return new ResponseEntity<String>("Welcome to ICE 2021 " + requestBody.get("name"), HttpStatus.OK);
	}

}
