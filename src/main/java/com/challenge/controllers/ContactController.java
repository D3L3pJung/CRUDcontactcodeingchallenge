package com.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dtos.ContactDto;
import com.challenge.services.ContactService;

@RestController
@RequestMapping("contacts")
public class ContactController {

	@Autowired
	private ContactService contactservice;
    
	@PostMapping
	public void createContact(@RequestBody ContactDto dto) {
		contactservice.createContact(dto);

	}

}
