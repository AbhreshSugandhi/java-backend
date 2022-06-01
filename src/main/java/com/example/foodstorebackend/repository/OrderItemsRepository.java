package com.example.foodstorebackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.foodstorebackend.model.OrderItems;

@Repository
public interface OrderItemsRepository extends CrudRepository<OrderItems, Integer> {
	
	public List<OrderItems> findByOrderId(Integer orderId);
}
