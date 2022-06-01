package com.example.foodstorebackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.foodstorebackend.model.UserAddress;

@Repository
public interface UserAddressRepository extends CrudRepository<UserAddress, Integer> {
	public List<UserAddress> findByUserId(Integer userId);
}
