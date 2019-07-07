package com.skilldistillery.pethouse.data;

import java.util.List;

import com.skilldistillery.pethouse.entities.PetHouse;

public interface PetHouseDAO {

	PetHouse update(int id, PetHouse pet);

	PetHouse create(PetHouse pet);

	boolean destroy(int id);

	List<PetHouse> getPetByType(String type);

	List<PetHouse> getAllPets();

}
