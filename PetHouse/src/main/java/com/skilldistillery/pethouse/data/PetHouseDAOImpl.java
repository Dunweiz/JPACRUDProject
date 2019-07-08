package com.skilldistillery.pethouse.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.pethouse.entities.Pethouse;

@Service
@Transactional
public class PetHouseDAOImpl implements PetHouseDAO {

	@PersistenceContext
	private EntityManager em;

	// Create a new pet
	@Override
	public Pethouse create(Pethouse pet) {
		em.persist(pet);
		em.close();
		return pet;
	}

	// Update an existing pet
	@Override
	public Pethouse update(int id, Pethouse pet) {
		Pethouse managed = em.find(Pethouse.class, id);
		managed.setName(pet.getName());
		managed.setAge(pet.getAge());
		managed.setType(pet.getType());

		em.close();
		return managed;
	}

	// Delete an existing pet
	@Override
	public boolean destroy(int id) {
		em.remove(em.find(Pethouse.class, id));
		return true;
	}

	// Get all the pets with a certain type
	@Override
	public List<Pethouse> getPetByType(String type) {
		String query = "SELECT p FROM PetHouse p WHERE p.type like :type";
		List<Pethouse> petType = em.createQuery(query, Pethouse.class).setParameter("type", type).getResultList();

		em.close();
		return petType;
	}

	// Get the complete list of pets
	@Override
	public List<Pethouse> getAllPets() {
		String query = "SELECT p FROM Pethouse p";
		List<Pethouse> pets = em.createQuery(query, Pethouse.class).getResultList();
		em.close();
		return pets;
	}

	// Get pet by id
	@Override
	public Pethouse findById(int id) {
		return em.find(Pethouse.class, id);
	}

}