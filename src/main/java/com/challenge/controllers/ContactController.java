package com.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping(value = "/{id}")
	public ContactDto showContact(@PathVariable int id) {
		return contactservice.getByContactid(id);

	}

	@GetMapping
	public List<ContactDto> showAllContact() {
		return contactservice.getAllContact();

	}

	@PutMapping(value = "/{id}")
	public void updateContact(@PathVariable int id, @RequestBody ContactDto dto) {
		contactservice.updateContactById(id, dto);

	}

	@DeleteMapping(value = "/{id}")
	public void deleteContact(@PathVariable int id) {
		contactservice.deleteContactById(id);

	}

}
