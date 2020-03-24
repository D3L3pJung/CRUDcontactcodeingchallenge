package com.challenge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.dtos.ContactDto;
import com.challenge.dtos.PhoneDto;
import com.challenge.entities.ContactEntity;
import com.challenge.entities.PhoneEntity;

@Service
public class PhoneService {

	public List<PhoneEntity> toEntity(ContactDto dto, ContactEntity entity) {
		List<PhoneEntity> phoneentity = new ArrayList<PhoneEntity>();
		List<PhoneDto> phonedto = dto.getPhone();

		for (PhoneDto phone : phonedto) {
			PhoneEntity entity11 = new PhoneEntity();
			entity11.setNumber(phone.getNumber());
			entity11.setType(phone.getType());
			entity11.setContact(entity);

			phoneentity.add(entity11);
		}
		return phoneentity;

	}

	public List<PhoneDto> toDto(ContactEntity entity) {
		List<PhoneDto> phonedto = new ArrayList<PhoneDto>();
		List<PhoneEntity> phoneentity = entity.getPhone();

		for (PhoneEntity phone : phoneentity) {
			PhoneDto dto1 = new PhoneDto();
			dto1.setNumber(phone.getNumber());
			dto1.setType(phone.getType());

			phonedto.add(dto1);
		}
		return phonedto;
	}

	public List<PhoneDto> toDto(Optional<ContactEntity> entity) {
		List<PhoneDto> phonedto = new ArrayList<PhoneDto>();
		List<PhoneEntity> phoneentity = entity.get().getPhone();

		for (PhoneEntity phone : phoneentity) {
			PhoneDto dto1 = new PhoneDto();
			dto1.setNumber(phone.getNumber());
			dto1.setType(phone.getType());

			phonedto.add(dto1);
		}

		return phonedto;
	}

	public List<PhoneEntity> toUpdateEntity(Optional<ContactDto> dto, ContactEntity entity) {
		List<PhoneEntity> phoneentity = entity.getPhone();
		List<PhoneDto> phonedto = dto.get().getPhone();

		for (PhoneDto phone : phonedto) {
			PhoneEntity entityphone = null;
			for (PhoneEntity p : phoneentity) {
				if (p.getType().equals(phone.getType())) {
					entityphone = p;
					break;
				}
			}
			if (entityphone == null) {
				entityphone = new PhoneEntity();
			}
			entityphone.setNumber(phone.getNumber());
			entityphone.setType(phone.getType());
			entityphone.setContact(entity);

			phoneentity.add(entityphone);
		}
		return phoneentity;

	}

}
