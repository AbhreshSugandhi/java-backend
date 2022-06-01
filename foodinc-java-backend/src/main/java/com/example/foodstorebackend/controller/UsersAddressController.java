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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodstorebackend.model.Response;
import com.example.foodstorebackend.model.UserAddress;
import com.example.foodstorebackend.repository.UserAddressRepository;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:4202" })
@RequestMapping("/user-addresses")
public class UsersAddressController {

	@Autowired
	UserAddressRepository repository;
	
	final String TAG = "User Address";
	
	@PostMapping(path= "/add")
	public Response<UserAddress> addUserAddress(@RequestParam Integer addressTag, @RequestParam Integer userId, @RequestParam String street, @RequestParam String city, @RequestParam String state,
	@RequestParam String country, @RequestParam Integer pincode) {
		Date date = new Date();
		
		UserAddress userAddress = new UserAddress(null, addressTag, userId, street, city, state, country, pincode);
		repository.save(userAddress);
		
		return new Response<UserAddress>(101, TAG+" Saved Successfully at "+date, Arrays.asList(userAddress));
		
	}
	
	@GetMapping(path="/get")
	public Response<UserAddress> getUserAddress(){
		ArrayList<UserAddress> list = new ArrayList<UserAddress>();
		repository.findAll().forEach((user) -> list.add(user));
		
		Date date = new Date();
		return new Response<UserAddress>(101, list.size()+" "+TAG+"s Fetched Successfully at "+date, list);
	}

	@GetMapping(path = "/get/{addressId}")
	public Response<UserAddress> getUserById(@PathVariable("addressId") Integer addressId){	
		UserAddress userAddress = repository.findById(addressId).get();
		Date date = new Date();
		
		return new Response<UserAddress>(101, TAG+" Fetched Successfully at "+date, Arrays.asList(userAddress));
	}

	@GetMapping(path = "/get/{userId}/addresses")
	public Response<UserAddress> getUserAddress(@PathVariable("userId") Integer userId){	
		List<UserAddress> userAddresses = repository.findByUserId(userId);
		Date date = new Date();

		return new Response<UserAddress>(101, userAddresses.size()+" "+TAG+" Fetched Successfully at "+date, userAddresses);
	}
	
	@PostMapping(path= "/update")
	public Response<UserAddress> updateUserAddress(@RequestParam Integer addressId, @RequestParam Integer addressTag, @RequestParam Integer userId, @RequestParam String street, @RequestParam String city, @RequestParam String state,
	@RequestParam String country, @RequestParam Integer pincode) {
		Date date = new Date();	
		UserAddress userAddress = new UserAddress(addressId, addressTag, userId, street, city, state, country, pincode);
		repository.save(userAddress);
		
		return new Response<UserAddress>(101, TAG+" Updated Successfully at "+date, Arrays.asList(userAddress));
	}
	
	@GetMapping(path = "/delete/{addressId}")
	public Response<UserAddress> deleteUser(@PathVariable("addressId") Integer addressId){
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(addressId);
		repository.delete(userAddress);
		
		Date date = new Date();
		return new Response<UserAddress>(101, TAG+" Deleted Successfully at "+date, null);
	}
	
}
