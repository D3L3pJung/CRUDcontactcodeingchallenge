package com.challenge.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

	public ContactDto getByContactid(int id) {
		Optional<ContactEntity> entity = contactrepository.findById(id);
		ContactDto dto = null;
		if (entity.isPresent()) {
			dto = new ContactDto();
			NameDto namedto = new NameDto();
			NameEntity nameentity = entity.get().getName();
			namedto.setFirst(nameentity.getFirst());
			namedto.setMiddle(nameentity.getMiddle());
			namedto.setLast(nameentity.getLast());
			dto.setName(namedto);

			AddressDto addressdto = new AddressDto();
			AddressEntity addressentity = entity.get().getAddress();
			addressdto.setStreet(addressentity.getStreet());
			addressdto.setCity(addressentity.getCity());
			addressdto.setState(addressentity.getState());
			addressdto.setZip(addressentity.getZip());
			dto.setAddress(addressdto);

			List<PhoneDto> phonedto = new ArrayList<PhoneDto>();
			List<PhoneEntity> phoneentity = entity.get().getPhone();

			for (PhoneEntity phone : phoneentity) {
				PhoneDto dto1 = new PhoneDto();
				dto1.setNumber(phone.getNumber());
				dto1.setType(phone.getType());

				phonedto.add(dto1);
			}
			dto.setPhone(phonedto);
			dto.setEmail(entity.get().getEmail());

		}
		return dto;

	}

	public List<ContactDto> getAllContact() {
		Iterable<ContactEntity> entity = contactrepository.findAll();
		List<ContactDto> dto = new ArrayList<ContactDto>();
		for (ContactEntity contact : entity) {
			ContactDto dtoo = new ContactDto();

			NameDto namedto = new NameDto();
			NameEntity nameentity = contact.getName();
			namedto.setFirst(nameentity.getFirst());
			namedto.setMiddle(nameentity.getMiddle());
			namedto.setLast(nameentity.getLast());
			dtoo.setName(namedto);

			AddressDto addressdto = new AddressDto();
			AddressEntity addressentity = contact.getAddress();
			addressdto.setStreet(addressentity.getStreet());
			addressdto.setCity(addressentity.getCity());
			addressdto.setState(addressentity.getState());
			addressdto.setZip(addressentity.getZip());
			dtoo.setAddress(addressdto);

			List<PhoneDto> phonedto = new ArrayList<PhoneDto>();
			List<PhoneEntity> phoneentity = contact.getPhone();
			for (PhoneEntity phone : phoneentity) {
				PhoneDto phonedto1 = new PhoneDto();
				phonedto1.setNumber(phone.getNumber());
				phonedto1.setType(phone.getType());

				phonedto.add(phonedto1);
			}
			dtoo.setPhone(phonedto);
			dtoo.setEmail(contact.getEmail());

			dto.add(dtoo);

		}
		return dto;

	}

	public void updateContactById(int id, ContactDto dto) {
		Optional<ContactEntity> entity = contactrepository.findById(id);
		if (entity.isPresent()) {
			ContactEntity contactentity = entity.get();
			NameEntity nameentity = contactentity.getName();
			NameDto namedto = dto.getName();
			nameentity.setFirst(namedto.getFirst());
			nameentity.setMiddle(namedto.getMiddle());
			nameentity.setLast(namedto.getLast());
			nameentity.setContact(contactentity);
			contactentity.setName(nameentity);

			AddressEntity addressentity = contactentity.getAddress();
			AddressDto addressdto = dto.getAddress();
			addressentity.setStreet(addressdto.getStreet());
			addressentity.setCity(addressdto.getCity());
			addressentity.setState(addressdto.getState());
			addressentity.setZip(addressdto.getZip());
			addressentity.setContact(contactentity);
			contactentity.setAddress(addressentity);

			List<PhoneEntity> phoneentity = contactentity.getPhone();
			List<PhoneDto> phonedto = dto.getPhone();

			for (PhoneDto phone : phonedto) {
				PhoneEntity entityphone = null;
				if (entityphone == null) {
					entityphone = new PhoneEntity();
				} else {
					entityphone.setNumber(phone.getNumber());
					entityphone.setType(phone.getType());
					entityphone.setContact(contactentity);

					phoneentity.add(entityphone);
				}
			}
			contactentity.setPhone(phoneentity);

			contactentity.setEmail(dto.getEmail());
			contactentity.setUpdatedAt(new Date());
			contactentity.setUuid(UUID.randomUUID().toString());

			contactrepository.save(contactentity);

		}
	}

	public void deleteContactById(int id) {

		contactrepository.deleteById(id);

	}

}
