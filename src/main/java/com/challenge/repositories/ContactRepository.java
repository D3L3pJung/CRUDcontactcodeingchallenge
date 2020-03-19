package com.challenge.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entities.ContactEntity;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Integer>{

}
