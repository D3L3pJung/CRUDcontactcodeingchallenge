package com.challenge.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.dtos.ContactDto;
import com.challenge.dtos.NameDto;
import com.challenge.entities.ContactEntity;
import com.challenge.entities.NameEntity;

@Service
public class NameService {

	public NameEntity toEntity(ContactDto dto, ContactEntity entity) {
		NameEntity nameentity = new NameEntity();
		NameDto namedto = dto.getName();
		nameentity.setFirst(namedto.getFirst());
		nameentity.setMiddle(namedto.getMiddle());
		nameentity.setLast(namedto.getLast());
		nameentity.setContact(entity);

		return nameentity;

	}

	public NameDto toDto(ContactEntity entity) {
		NameEntity nameentity = entity.getName();
		NameDto namedto = new NameDto();
		namedto.setFirst(nameentity.getFirst());
		namedto.setMiddle(nameentity.getMiddle());
		namedto.setLast(nameentity.getLast());

		return namedto;

	}

	public NameDto toDto(Optional<ContactEntity> entity) {
		NameEntity nameentity = entity.get().getName();
		NameDto namedto = new NameDto();
		namedto.setFirst(nameentity.getFirst());
		namedto.setMiddle(nameentity.getMiddle());
		namedto.setLast(nameentity.getLast());

		return namedto;
	}

	public NameEntity toUpdateByIdEntity(Optional<ContactDto> dto, ContactEntity entity) {
		NameEntity nameentity = entity.getName();
		NameDto namedto = dto.get().getName();
		nameentity.setFirst(namedto.getFirst());
		nameentity.setMiddle(namedto.getMiddle());
		nameentity.setLast(namedto.getLast());
		nameentity.setContact(entity);

		return nameentity;

	}

}
