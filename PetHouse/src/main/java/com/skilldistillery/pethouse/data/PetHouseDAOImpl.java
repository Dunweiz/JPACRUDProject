package com.skilldistillery.pethouse.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.pethouse.entities.PetHouse;

@Service
@Transactional
public class PetHouseDAOImpl implements PetHouseDAO {

	@PersistenceContext
	private EntityManager em;

	// Create a new pet
	@Override
	public PetHouse create(PetHouse pet) {
		em.getTransaction().begin();
		em.persist(pet);
		em.flush();
		em.getTransaction().commit();
		em.close();
		return pet;
	}

	// Update an existing pet
	@Override
	public PetHouse update(int id, PetHouse pet) {
		em.getTransaction().begin();
		PetHouse managed = em.find(PetHouse.class, id);
		managed.setName(pet.getName());
		managed.setAge(pet.getAge());
		managed.setType(pet.getType());

		em.getTransaction().commit();
		em.close();
		return managed;
	}

	// Delete an existing pet
	@Override
	public boolean destroy(int id) {
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
		String query = "SELECT p FROM PetHouse p WHERE p.type like :type";
		List<PetHouse> petType = em.createQuery(query, PetHouse.class).setParameter("type", type).getResultList();

		em.close();
		return petType;
	}

	// Get the complete list of pets
	@Override
	public List<PetHouse> getAllPets() {

		String query = "SELECT p FROM PetHouse p";
		List<PetHouse> pets = em.createQuery(query, PetHouse.class).getResultList();
		em.close();
		return pets;
	}

	// Get pet by id
	@Override
	public PetHouse findById(int id) {
		return em.find(PetHouse.class, id);
	}

}