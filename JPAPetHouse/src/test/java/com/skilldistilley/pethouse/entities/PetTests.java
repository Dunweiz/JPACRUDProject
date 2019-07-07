package com.skilldistilley.pethouse.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.pethouse.entities.PetHouse;

class PetTests {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private PetHouse pet;
	
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
		pet = em.find(PetHouse.class, 1);
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
		assertEquals("dog", pet.getType());
		assertEquals(2, pet.getAge());
		assertEquals("sprinkles", pet.getName());
	}

}
