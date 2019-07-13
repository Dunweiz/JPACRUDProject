package com.skilldistillery.pethouse.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pethouse")
public class Pethouse {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name="type_id")
	private Pettype type;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	private int age;
	
	private String name;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pettype getType() {
		return type;
	}

	public void setType(Pettype type) {
		this.type = type;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pethouse [id=" + id + ", type=" + type + ", owner=" + owner + ", age=" + age + ", name=" + name + "]";
	}
	
	
	
	
	
}
