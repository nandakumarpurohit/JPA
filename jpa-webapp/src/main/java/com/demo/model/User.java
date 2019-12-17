package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String lastName;
	
	private String city;
	
	private String zipCode;
	
	public User() {
		
	}

	public User(String name) {
		this.name = name;
	}
	
	public User(String name, String lastName, String city, String zipcode) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.city = city;
		this.zipCode = zipcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", city=" + city + ", zipCode="
				+ zipCode + "]";
	}
	
}
