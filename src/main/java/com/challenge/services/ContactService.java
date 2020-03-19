package com.challenge.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dtos.AddressDto;
import com.challenge.dtos.ContactDto;
import com.challenge.dtos.NameDto;
import com.challenge.dtos.PhoneDto;
import com.challenge.entities.AddressEntity;
import com.challenge.entities.ContactEntity;
import com.challenge.entities.NameEntity;
import com.challenge.entities.PhoneEntity;
import com.challenge.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactrepository;

	public void createContact(ContactDto dto) {
		ContactEntity entity = new ContactEntity();

		NameEntity nameentity = new NameEntity();
		NameDto namedto = dto.getName();
		nameentity.setFirst(namedto.getFirst());
		nameentity.setMiddle(namedto.getMiddle());
		nameentity.setLast(namedto.getLast());
		nameentity.setContact(entity);
		entity.setName(nameentity);

		AddressEntity addressentity = new AddressEntity();
		AddressDto addressdto = dto.getAddress();
		addressentity.setStreet(addressdto.getStreet());
		addressentity.setCity(addressdto.getCity());
		addressentity.setState(addressdto.getState());
		addressentity.setZip(addressdto.getZip());
		addressentity.setContact(entity);
		entity.setAddress(addressentity);

		List<PhoneEntity> phoneentity = new ArrayList<PhoneEntity>();
		List<PhoneDto> phonedto = dto.getPhone();

		for (PhoneDto phone : phonedto) {
			PhoneEntity entity11 = new PhoneEntity();
			entity11.setNumber(phone.getNumber());
			entity11.setType(phone.getType());
			entity11.setContact(entity);

			phoneentity.add(entity11);
		}
		entity.setPhone(phoneentity);
		entity.setEmail(dto.getEmail());
		entity.setCreatedAt(new Date());
		entity.setUpdatedAt(new Date());
		entity.setUuid(UUID.randomUUID().toString());

		contactrepository.save(entity);

	}
}
