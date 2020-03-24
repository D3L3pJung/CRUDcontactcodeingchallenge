package com.challenge.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.dtos.AddressDto;
import com.challenge.dtos.ContactDto;
import com.challenge.entities.AddressEntity;
import com.challenge.entities.ContactEntity;

@Service
public class AddressService {

	public AddressEntity toEntity(ContactDto dto, ContactEntity entity) {
		AddressDto addressdto = dto.getAddress();
		AddressEntity addressentity = new AddressEntity();
		addressentity.setStreet(addressdto.getStreet());
		addressentity.setCity(addressdto.getCity());
		addressentity.setState(addressdto.getState());
		addressentity.setZip(addressdto.getZip());
		addressentity.setContact(entity);

		return addressentity;

	}

	public AddressDto toDto(ContactEntity entity) {
		AddressEntity addressentity = entity.getAddress();
		AddressDto addressdto = new AddressDto();
		addressdto.setStreet(addressentity.getStreet());
		addressdto.setCity(addressentity.getCity());
		addressdto.setState(addressentity.getState());
		addressdto.setZip(addressentity.getZip());

		return addressdto;
	}

	public AddressDto toDto(Optional<ContactEntity> entity) {
		AddressEntity addressentity = entity.get().getAddress();
		AddressDto addressdto = new AddressDto();
		addressdto.setStreet(addressentity.getStreet());
		addressdto.setCity(addressentity.getCity());
		addressdto.setState(addressentity.getState());
		addressdto.setZip(addressentity.getZip());

		return addressdto;
	}

	public AddressEntity toUpdateByIdEntity(Optional<ContactDto> dto, ContactEntity entity) {
		AddressDto addressdto = dto.get().getAddress();
		AddressEntity addressentity = entity.getAddress();
		addressentity.setStreet(addressdto.getStreet());
		addressentity.setCity(addressdto.getCity());
		addressentity.setState(addressdto.getState());
		addressentity.setZip(addressdto.getZip());
		addressentity.setContact(entity);

		return addressentity;

	}

}
