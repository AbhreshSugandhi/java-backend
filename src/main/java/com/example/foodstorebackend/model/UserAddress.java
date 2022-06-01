package com.example.foodstorebackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer addressId;
	Integer addressTag;
	Integer userId;
	String street;
	String city;
	String state;
	String country;
	Integer pincode;
	
	public UserAddress() {
		
	}

	public UserAddress(Integer addressId, Integer addressTag, Integer userId, String street, String city, String state,
			String country, Integer pincode) {
		super();
		this.addressId = addressId;
		this.addressTag = addressTag;
		this.userId = userId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getAddressTag() {
		return addressTag;
	}

	public void setAddressTag(Integer addressTag) {
		this.addressTag = addressTag;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "UserAddress [addressId=" + addressId + ", addressTag=" + addressTag + ", userId=" + userId + ", street="
				+ street + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode
				+ "]";
	}
	
}
