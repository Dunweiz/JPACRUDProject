package com.skilldistillery.pethouse.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.pethouse.entities.PetHouse;

public class PetHouseDAOImpl implements PetHouseDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetHouse");

	
	//Create a new pet
	@Override
	public PetHouse create(PetHouse pet) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pet);
		em.flush();
		em.getTransaction().commit();
		em.close();
		return pet;
	}
	//Update an existing pet
	@Override
	public PetHouse update(int id, PetHouse pet) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		PetHouse managed = em.find(PetHouse.class, id);
		managed.setName(pet.getName());
		managed.setAge(pet.getAge());
		managed.setType(pet.getType());

		em.getTransaction().commit();
		em.close();
		return managed;
	}
	//Delete an existing pet
	@Override
	public boolean destroy(int id) {
		EntityManager em = emf.createEntityManager();
		PetHouse pet = em.find(PetHouse.class, id);
		em.getTransaction().begin();

		em.remove(pet);

		em.getTransaction().commit();
		em.close();
		return true;

	}
	// Get all the pets with a certain type
	@Override
	public List<PetHouse> getPetByType(String type) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT p FROM PetHouse p WHERE p.type like :type";
		List<PetHouse> petType = em.createQuery(query, PetHouse.class).setParameter("type", type).getResultList();

		em.close();
		return petType;
	}
	// Get the complete list of pets
	@Override
	public List<PetHouse> getAllPets() {
		EntityManager em = emf.createEntityManager();
		
		String query = "SELECT pet FROM PetHouse pet";
		List<PetHouse> pets = em.createQuery(query, PetHouse.class).getResultList();
		em.close();
		return pets;
	}
}
