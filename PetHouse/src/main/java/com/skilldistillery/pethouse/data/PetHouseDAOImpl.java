package com.skilldistillery.pethouse.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.pethouse.entities.Address;
import com.skilldistillery.pethouse.entities.Owner;
import com.skilldistillery.pethouse.entities.Pethouse;
import com.skilldistillery.pethouse.entities.Pettype;

@Service
@Transactional
public class PetHouseDAOImpl implements PetHouseDAO {

	@PersistenceContext
	private EntityManager em;

	// Registers a new Pet with all of the Information required (Adds to data base)
	@Override
	public Pethouse create(Pethouse pet) {
		Owner owner = new Owner();
		Address addr = new Address();
		owner.setFirstName(pet.getOwner().getFirstName());
		owner.setLastName(pet.getOwner().getLastName());
		owner.setPhone(pet.getOwner().getPhone());
		
		addr.setAddress(pet.getOwner().getAddress().getAddress());
		addr.setCity(pet.getOwner().getAddress().getCity());
		addr.setState(pet.getOwner().getAddress().getState());
		addr.setZip(pet.getOwner().getAddress().getZip());
		
		em.persist(addr);
		owner.setAddress(addr);
		em.persist(owner);
		pet.setOwner(owner);
		em.persist(pet);
		em.flush();
		return pet;
	}

	// Update an existing pets DATA. Does not change owners or type;
	@Override
	public Pethouse update(int id, Pethouse pet) {
		Pethouse managed = em.find(Pethouse.class, id);
		Pettype type = em.find(Pettype.class, pet.getType().getId());
		Owner owner = em.find(Owner.class, pet.getOwner().getId());
		Address addr = em.find(Address.class, pet.getOwner().getAddress().getId());
		
		managed.setName(pet.getName());
		managed.setAge(pet.getAge());
		
		
		owner.setFirstName(pet.getOwner().getFirstName());
		owner.setLastName(pet.getOwner().getLastName());
		owner.setPhone(pet.getOwner().getPhone());
		
		addr.setAddress(pet.getOwner().getAddress().getAddress());
		addr.setCity(pet.getOwner().getAddress().getCity());
		addr.setState(pet.getOwner().getAddress().getState());
		addr.setZip(pet.getOwner().getAddress().getZip());
		
		managed.setType(type);
		managed.setOwner(owner);
		
		return managed;
	}
	
	//Update an existing Owner DATA.
	@Override
	public Owner update(int id, Owner owner) {
		Owner managed = em.find(Owner.class, id);
		Address addr = em.find(Address.class, owner.getAddress().getId());
		
		managed.setAddress(addr);
		managed.setFirstName(owner.getFirstName());
		managed.setLastName(owner.getLastName());
		managed.setPhone(owner.getPhone());
		
		return managed;
		
	}
	
	//Update an existing Address DATA.
	@Override
	public Address address(int id, Address address) {
		Address addr = em.find(Address.class, id);
		addr.setAddress(address.getAddress());
		addr.setCity(address.getCity());
		addr.setState(address.getState());
		addr.setZip(address.getZip());
		return addr;
	}

	// Delete an existing pet
	@Override
	public boolean destroy(int id) {
		em.remove(em.find(Pethouse.class, id));
		return true;
	}

	// Get all the pets with a certain type
	@Override
	public List<Pethouse> getPetByType(int type) {
		String query = "SELECT p FROM PetHouse p WHERE p.type.id = :type";
		List<Pethouse> petType = em.createQuery(query, Pethouse.class).setParameter("type", type).getResultList();

		return petType;
	}

	// Get the complete list of pets
	@Override
	public List<Pethouse> getAllPets() {
		String query = "SELECT p FROM Pethouse p";
		List<Pethouse> pets = em.createQuery(query, Pethouse.class).getResultList();
		return pets;
	}

	// Get pet by id
	@Override
	public Pethouse findById(int id) {
		return em.find(Pethouse.class, id);
	}

}