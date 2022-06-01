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
public class Dishes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer dishId;

    Integer restaurantId;
    String restaurantName;
    String restaurantAddress;

    String name;
    String description;
    Integer price;
    Integer rating;

    @ElementCollection
	@CollectionTable(name = "DishIngredients", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "ingredients")
	List<String> ingredients;

    @ElementCollection
    @CollectionTable(name = "DishImages", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "list")
    List<String> images;
    Integer thumbnailImage;

    Integer status;
    Date addedOn;
    
    public Dishes() {
		// TODO Auto-generated constructor stub
	}

	public Dishes(Integer dishId, Integer restaurantId, String restaurantName, String restaurantAddress, String name,
			String description, Integer price, Integer rating, List<String> ingredients, List<String> images,
			Integer thumbnailImage, Integer status, Date addedOn) {
		this.dishId = dishId;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.name = name;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.ingredients = ingredients;
		this.images = images;
		this.thumbnailImage = thumbnailImage;
		this.status = status;
		this.addedOn = addedOn;
	}

	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
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

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Dishes [dishId=" + dishId + ", restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantAddress=" + restaurantAddress + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", rating=" + rating + ", ingredients=" + ingredients + ", images=" + images
				+ ", thumbnailImage=" + thumbnailImage + ", status=" + status + ", addedOn=" + addedOn + "]";
	}   
    
}
