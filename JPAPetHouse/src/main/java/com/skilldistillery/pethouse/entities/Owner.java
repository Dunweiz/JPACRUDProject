package com.skilldistillery.pethouse.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String phone;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(mappedBy="owner")
	private List<Pethouse> pets;

	public void addPet(Pethouse pet) {
		if(pets == null) { pets = new ArrayList<>();}
		if(!pets.contains(pet)) {
			pets.add(pet);
			
		}
	}
	
	public void removePet(Pethouse pet) {
		if(pets != null && pets.contains(pet)) {
			pets.remove(pet);
		}
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + "]";
	}

	public List<Pethouse> getPets() {
		return pets;
	}

	public void setPets(List<Pethouse> pets) {
		this.pets = pets;
	}

	
	
	
}
