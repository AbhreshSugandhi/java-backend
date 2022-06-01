package com.example.foodstorebackend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Restaurants {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer restaurantId;
	String name;
	String description;
	String address;
    Long contact;
    String email;

	@ElementCollection
	@CollectionTable(name = "Images", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "list")
	List<String> images;
	Integer thumbnailImage;
	Integer rating;
	Integer status;
	Date addedOn;

	public Restaurants() {
		// TODO Auto-generated constructor stub
	}

	public Restaurants(Integer restaurantId, String name, String description, String address, List<String> images,
			Integer thumbnailImage, Integer rating, Integer status,  Date addedOn) {
		this.restaurantId = restaurantId;
		this.name = name;
		this.description = description;
		this.address = address;
		this.images = images;
		this.thumbnailImage = thumbnailImage;
		this.rating = rating;
		this.status = status;
		this.addedOn = addedOn;
	}
	
	public Restaurants(Integer restaurantId, String name, String description, String address, Long contact,
			String email, List<String> images, Integer thumbnailImage, Integer rating, Integer status, Date addedOn) {
		this.restaurantId = restaurantId;
		this.name = name;
		this.description = description;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.images = images;
		this.thumbnailImage = thumbnailImage;
		this.rating = rating;
		this.status = status;
		this.addedOn = addedOn;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Integer getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(Integer thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}
	
	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Restaurants [restaurantId=" + restaurantId + ", name=" + name + ", description=" + description
				+ ", address=" + address + ", contact=" + contact + ", email=" + email + ", images=" + images
				+ ", thumbnailImage=" + thumbnailImage + ", rating=" + rating + ", status=" + status + ", addedOn="
				+ addedOn + "]";
	}

}
