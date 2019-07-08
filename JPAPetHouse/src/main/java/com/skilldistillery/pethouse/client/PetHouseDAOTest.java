package com.skilldistillery.pethouse.client;

import com.skilldistillery.pethouse.data.PetHouseDAO;
import com.skilldistillery.pethouse.data.PetHouseDAOImpl;
import com.skilldistillery.pethouse.entities.PetHouse;

public class PetHouseDAOTest {

	public static void main(String[] args) {
		PetHouseDAO dao = new PetHouseDAOImpl();
		
		PetHouse pet = new PetHouse();
		
		pet.setAge(6);
		pet.setName("sprinkles");
		pet.setType("fish");
		System.out.println("Before db Stuff: " + pet);
		System.out.println(dao.create(pet));
		
//		PetHouse newPet = new PetHouse();
//		newPet.setName("Spots");
//		newPet.setAge(5);
//		System.out.println(dao.update(12, newPet));
		
//		dao.destroy(11);
	}
}
