package com.example.foodstorebackend.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.foodstorebackend.model.Dishes;

@Repository
public interface DishesRepository extends CrudRepository<Dishes, Integer> {
	public List<Dishes> findByRestaurantId(Integer restaurantId);
}
