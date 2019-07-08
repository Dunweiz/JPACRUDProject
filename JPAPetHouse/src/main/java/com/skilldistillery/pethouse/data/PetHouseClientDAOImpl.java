package com.skilldistillery.pethouse.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.pethouse.entities.Pethouse;

public class PetHouseClientDAOImpl {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetHouse");

	
	//Create a new pet
	public Pethouse create(Pethouse pet) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pet);
		em.flush();
		em.getTransaction().commit();
		em.close();
		return pet;
	}
	//Update an existing pet
	public Pethouse update(int id, Pethouse pet) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pethouse managed = em.find(Pethouse.class, id);
		managed.setName(pet.getName());
		managed.setAge(pet.getAge());
		managed.setType(pet.getType());

		em.getTransaction().commit();
		em.close();
		return managed;
	}
	//Delete an existing pet
	public boolean destroy(int id) {
		EntityManager em = emf.createEntityManager();
		Pethouse pet = em.find(Pethouse.class, id);
		em.getTransaction().begin();

		em.remove(pet);

		em.getTransaction().commit();
		em.close();
		return true;

	}
	// Get all the pets with a certain type
	public List<Pethouse> getPetByType(String type) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT p FROM PetHouse p WHERE p.type like :type";
		List<Pethouse> petType = em.createQuery(query, Pethouse.class).setParameter("type", type).getResultList();

		em.close();
		return petType;
	}
	// Get the complete list of pets
	public List<Pethouse> getAllPets() {
		EntityManager em = emf.createEntityManager();
		
		String query = "SELECT pet FROM PetHouse pet";
		List<Pethouse> pets = em.createQuery(query, Pethouse.class).getResultList();
		em.close();
		return pets;
	}
}
