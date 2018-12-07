package com.sti.bootcamp.wallet.model;

import java.util.Date;

public class Customer {
	private int customerNumber;
	private String firstName, lastName;
	private Date birthDate;
	private String username, password;
	private String phoneNumber, phoneType;
	
	public Customer() {}
	public Customer(int customerNumber, String firstName, String lastName, Date birthDate, String username, String password, String phoneNumber, String phoneType) {
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.phoneType = phoneType;
	}
	
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
}
