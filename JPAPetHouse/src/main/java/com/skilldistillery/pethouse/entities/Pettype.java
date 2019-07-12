package com.skilldistillery.pethouse.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pet_type")
public class Pettype {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String species;
	
	@OneToMany(mappedBy="type")
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

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	

	

	
	
	public List<Pethouse> getPets() {
		return pets;
	}

	public void setPets(List<Pethouse> pets) {
		this.pets = pets;
	}

	@Override
	public String toString() {
		return "Pettype [id=" + id + ", species=" + species + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((pets == null) ? 0 : pets.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pettype other = (Pettype) obj;
		if (id != other.id)
			return false;
		if (pets == null) {
			if (other.pets != null)
				return false;
		} else if (!pets.equals(other.pets))
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		return true;
	}
	
	
	
	
}
