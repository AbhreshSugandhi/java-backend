package com.example.foodstorebackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer cartId;
	Integer dishId;
	Integer userId;
	Integer quantity = 1;
	
	public Cart() {
		
	}

	public Cart(Integer cartId, Integer dishId, Integer userId) {
		super();
		this.cartId = cartId;
		this.dishId = dishId;
		this.userId = userId;
	}

	public Cart(Integer cartId, Integer dishId, Integer userId, Integer quantity) {
		super();
		this.cartId = cartId;
		this.dishId = dishId;
		this.userId = userId;
		this.quantity = quantity;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", dishId=" + dishId + ", userId=" + userId + ", quantity=" + quantity + "]";
	}
	
}
