package com.skilldistillery.pethouse.data;

import java.util.List;

import com.skilldistillery.pethouse.entities.Pethouse;

public interface PetHouseDAO {
	Pethouse update(int id, Pethouse pet);

	Pethouse create(Pethouse pet);

	boolean destroy(int id);

	List<Pethouse> getPetByType(String type);

	List<Pethouse> getAllPets();

	Pethouse findById(int id);
}
