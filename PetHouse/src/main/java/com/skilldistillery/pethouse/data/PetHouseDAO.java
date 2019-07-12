package com.skilldistillery.pethouse.data;

import java.util.List;

import com.skilldistillery.pethouse.entities.Address;
import com.skilldistillery.pethouse.entities.Owner;
import com.skilldistillery.pethouse.entities.Pethouse;
import com.skilldistillery.pethouse.entities.Pettype;

public interface PetHouseDAO {
	Pethouse update(int id, Pethouse pet);

	boolean destroy(int id);

	List<Pethouse> getAllPets();

	Pethouse findById(int id);

	Pethouse create(Pethouse pet);

	List<Pethouse> getPetByType(int type);

	Owner update(int id, Owner owner);

	Address address(int id, Address address);
}
