package com.example.foodstorebackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.foodstorebackend.model.Restaurants;

@Repository
public interface RestaurantsRepository extends CrudRepository<Restaurants, Integer> {

}
