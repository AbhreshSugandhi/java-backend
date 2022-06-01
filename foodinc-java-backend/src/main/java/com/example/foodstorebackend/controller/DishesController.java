package com.example.foodstorebackend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodstorebackend.model.Dishes;
import com.example.foodstorebackend.model.Response;
import com.example.foodstorebackend.model.Restaurants;
import com.example.foodstorebackend.repository.DishesRepository;


@RestController
@RequestMapping(path = "/dishes")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:4202" })
public class DishesController {

    @Autowired
    DishesRepository repository;

    final String TAG = "Dish";
    @PostMapping(path= "/add")
	public Response<Dishes> addDish(@RequestParam Integer restaurantId, @RequestParam String restaurantName, @RequestParam String restaurantAddress, @RequestParam String name,
        @RequestParam String description, @RequestParam Integer price, @RequestParam Integer rating, @RequestParam List<String> ingredients, @RequestParam List<String> images,
        @RequestParam Integer thumbnailImage, @RequestParam Integer status) {		
		Date date = new Date();
		Dishes dish = new Dishes(null, restaurantId, restaurantName, restaurantAddress, name, description, price, rating, ingredients, images, thumbnailImage, status, date);
		repository.save(dish);
		
		return new Response<Dishes>(101, TAG+" Added Successfully at "+date, Arrays.asList(dish));
	}
	
	@PostMapping(path= "/update")
	public Response<Dishes> updateDish(@RequestParam Integer dishId, @RequestParam Integer restaurantId, @RequestParam String restaurantName, @RequestParam String restaurantAddress, @RequestParam String name,
        @RequestParam String description, @RequestParam Integer price, @RequestParam Integer rating, @RequestParam List<String> ingredients, @RequestParam List<String> images,
        @RequestParam Integer thumbnailImage, @RequestParam Integer status) {		
		Date date = new Date();
		Dishes dish = new Dishes(dishId, restaurantId, restaurantName, restaurantAddress, name, description, price, rating, ingredients, images, thumbnailImage, status, date);
		repository.save(dish);
		
		return new Response<Dishes>(101, TAG+" Updated Successfully at "+date, Arrays.asList(dish));
	}
	
	@PostMapping(path = "/update/{dishId}")
	public Response<Dishes> updateRestaurantImage(@PathVariable("dishId") Integer dishId, @RequestBody List<String> images) {
		Dishes dish = repository.findById(dishId).get();
		dish.setImages(images);
		repository.save(dish);
		Date date = new Date();
		return new Response<Dishes>(101, TAG+" Updated Successfully at "+date, Arrays.asList(dish));
	}

	@GetMapping(path = "/get")
	public Response<Dishes> getDishes() {
		List<Dishes> dishes = new ArrayList<Dishes>();
		repository.findAll().forEach((dish) -> dishes.add(dish));

		Date date = new Date();
		return new Response<Dishes>(101, dishes.size()+" "+TAG+"s Fetched Successfully at "+date, dishes);
	}
	
	@GetMapping(path = "/get/dishes")
	public Response<Dishes> getAllProductsByUserId(@Param("dishIds") String dishIds) {
		List<Integer> prdIds = new ArrayList<Integer>();
		for(String id: dishIds.split(",")) {
			prdIds.add(Integer.parseInt(id));
		}
		
		Date date = new Date();
		ArrayList<Dishes> list = new ArrayList<Dishes>();
		repository.findAllById(prdIds).forEach((dish) -> list.add(dish));
		
		return new Response<Dishes>(101, list.size()+" "+TAG+"s Fetched Successfully at "+date, list);
	}

	@GetMapping(path = "/get/{restaurantId}/dishes")
	public Response<Dishes> getRestaurantDishes(@PathVariable(name = "restaurantId") Integer restaurantId) {
		List<Dishes> dishes = repository.findByRestaurantId(restaurantId);
		Date date = new Date();
		return new Response<Dishes>(101, dishes.size()+" "+TAG+"s Fetched Successfully at "+date, dishes);
	}

	@GetMapping(path = "/delete/{id}")
	public Response<Dishes> deleteDish(@PathVariable("id") Integer id){
		Dishes dish = new Dishes();
		dish.setDishId(id);
		repository.delete(dish);
		
		Date date = new Date();
		return new Response<Dishes>(101, TAG+" Deleted Successfully at "+date, null);
	}
}
