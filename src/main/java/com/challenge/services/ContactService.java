package com.challenge.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dtos.ContactDto;
import com.challenge.entities.ContactEntity;
import com.challenge.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactrepository;

	@Autowired
	private NameService nameservice;

	@Autowired
	private AddressService addressservice;

	@Autowired
	private PhoneService phoneservice;

	public void createNewContact(ContactDto dto) {
		ContactEntity entity = new ContactEntity();
		entity.setName(nameservice.toEntity(dto, entity));
		entity.setAddress(addressservice.toEntity(dto, entity));
		entity.setPhone(phoneservice.toEntity(dto, entity));
		entity.setEmail(dto.getEmail());
		entity.setCreatedAt(new Date());
		entity.setUpdatedAt(new Date());
		entity.setUuid(UUID.randomUUID().toString());

		contactrepository.save(entity);

	}

	public ContactDto getContactById(int id) {
		Optional<ContactEntity> entity = contactrepository.findById(id);
		ContactDto dto = null;
		if (entity.isPresent()) {
			dto = new ContactDto();
			dto.setName(nameservice.toDto(entity));
			dto.setAddress(addressservice.toDto(entity));
			dto.setPhone(phoneservice.toDto(entity));
			dto.setEmail(entity.get().getEmail());
		}
		return dto;

	}

	public List<ContactDto> getAllContact() {
		Iterable<ContactEntity> entity = contactrepository.findAll();
		List<ContactDto> contactdto = new ArrayList<ContactDto>();
		for (ContactEntity contactentity : entity) {
			ContactDto dto = new ContactDto();
			dto.setName(nameservice.toDto(contactentity));
			dto.setAddress(addressservice.toDto(contactentity));
			dto.setPhone(phoneservice.toDto(contactentity));
			dto.setEmail(contactentity.getEmail());

			contactdto.add(dto);

		}
		return contactdto;
	}

	public void updateById(int id, ContactDto dto) {
		Optional<ContactEntity> contactentity = contactrepository.findById(id);
		ContactEntity entity = null;
		if (contactentity.isPresent()) {
			entity = contactentity.get();
			entity.setName(nameservice.toEntity(dto, entity));
			entity.setAddress(addressservice.toEntity(dto, entity));
			entity.setPhone(phoneservice.toEntity(dto, entity));
			entity.setEmail(dto.getEmail());

		}
		contactrepository.save(entity);

	}

	public void deleteContactById(int id) {

		contactrepository.deleteById(id);

	}

}
