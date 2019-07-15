package com.skilldistilley.pethouse.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.pethouse.entities.Address;
import com.skilldistillery.pethouse.entities.Owner;
import com.skilldistillery.pethouse.entities.Pethouse;
import com.skilldistillery.pethouse.entities.Pettype;

class PetTests {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Pethouse pet;
	private Pettype type;
	private Owner owner;
	private Address addr;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("PetHouse");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		pet = em.find(Pethouse.class, 1);
		type = em.find(Pettype.class, 1);
		owner = em.find(Owner.class, 1);
		addr = em.find(Address.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		pet = null;
	}

	@Test
	void test() {
		assertNotNull(pet);
		assertEquals(1, pet.getId());
		assertEquals("Canine", pet.getType().getSpecies());
		assertEquals(1, pet.getType().getId());
		assertEquals(2, pet.getAge());
		assertEquals("Sprinkle", pet.getName());
		assertEquals("New York", pet.getOwner().getAddress().getState() );
		assertEquals("Rob", pet.getOwner().getFirstName());
	}

	@Test
	void test_Owner() {
		assertNotNull(owner);
		assertEquals("Rob", owner.getFirstName());
		assertEquals("Sprinkle", owner.getPets().get(0).getName());
	}
	@Test
	void test_type() {
		assertNotNull(type);
		assertTrue(type.getPets().size() > 0);
		assertEquals("Canine", type.getSpecies());
	}
	@Test
	void test_Address() {
		assertNotNull(addr);
		assertEquals("New York", addr.getState());
		assertEquals("33952", addr.getZip());
	}
}
