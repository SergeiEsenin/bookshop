package com.example.bookshop.repo;

import com.example.bookshop.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Order,Long> {

}
