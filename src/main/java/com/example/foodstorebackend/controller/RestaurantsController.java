package com.example.foodstorebackend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodstorebackend.model.Response;
import com.example.foodstorebackend.model.Restaurants;
//import com.example.foodstorebackend.repository.DishesRepository;
import com.example.foodstorebackend.repository.RestaurantsRepository;

@RestController
@RequestMapping(path = "/restaurants")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:4202" })
public class RestaurantsController {

	@Autowired
	RestaurantsRepository repository;
	
	final String TAG = "Restaurant";

	@PostMapping(path= "/add")
	public Response<Restaurants> addRestaurant(@RequestParam String name, @RequestParam String description, @RequestParam String address, @RequestParam Long contact,
	@RequestParam String email, @RequestParam List<String> images, @RequestParam Integer thumbnailImage, @RequestParam Integer rating, @RequestParam Integer status, @RequestParam Date addedOn) {		
		Date date = new Date();
		Restaurants restaurant = new Restaurants(null, name, description, address, contact, email, images, thumbnailImage, rating, status, date);
		repository.save(restaurant);
		
		return new Response<Restaurants>(101, TAG+" Added Successfully at "+date, Arrays.asList(restaurant));
	}
	
	@PostMapping(path= "/update")
	public Response<Restaurants> updateRestaurant(@RequestParam Integer restaurantId, @RequestParam String name, @RequestParam String description, @RequestParam String address, @RequestParam Long contact,
	@RequestParam String email, @RequestParam List<String> images, @RequestParam Integer thumbnailImage, @RequestParam Integer rating, @RequestParam Integer status, @RequestParam Date addedOn) {		
		Date date = new Date();
		Restaurants restaurant = new Restaurants(restaurantId, name, description, address, contact, email, images, thumbnailImage, rating, status, date);
		repository.save(restaurant);
		
		return new Response<Restaurants>(101, TAG+" Updated Successfully at "+date, Arrays.asList(restaurant));
		
	}
	
	@PostMapping(path = "/update/{restaurantId}")
	public Response<Restaurants> updateRestaurantImage(@PathVariable("restaurantId") Integer restaurantId, @RequestBody List<String> images) {
		Restaurants restaurant = repository.findById(restaurantId).get();
		restaurant.setImages(images);
		repository.save(restaurant);
		Date date = new Date();
		return new Response<Restaurants>(101, TAG+" Updated Successfully at "+date, Arrays.asList(restaurant));
	}

	@GetMapping(path = "/get")
	public Response<Restaurants> getRestaurants() {
		List<Restaurants> restaurants = new ArrayList<Restaurants>();
		repository.findAll().forEach((restaurant) -> restaurants.add(restaurant));

		Date date = new Date();
		return new Response<Restaurants>(101, restaurants.size()+" "+TAG+"s Fetched Successfully at "+date, restaurants);
	}
	
	@GetMapping(path = "/get/{restaurantId}")
	public Response<Restaurants> getRestaurantById(@PathVariable("restaurantId") Integer restaurantId) {
		Restaurants restaurant = repository.findById(restaurantId).get();
		Date date = new Date();
		return new Response<Restaurants>(101, TAG+"s Fetched Successfully at "+date, Arrays.asList(restaurant));
	}
	
	@GetMapping(path = "/delete/{id}")
	public Response<Restaurants> deleteRestarant(@PathVariable("id") Integer id){
		Restaurants restaurant = new Restaurants();
		restaurant.setRestaurantId(id);
		repository.delete(restaurant);
		
		Date date = new Date();
		return new Response<Restaurants>(101, TAG+" Deleted Successfully at "+date, null);
	}
	
}
