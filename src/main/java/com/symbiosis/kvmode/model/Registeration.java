package com.symbiosis.kvmode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Registeration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
	private String name, dateofbirth,email, phone, address, password;
	public Registeration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Registeration(String name, String dateofbirth, String email, String phone, String address,
			String password) {
		super();
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.password = password;
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
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
