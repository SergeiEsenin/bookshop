package com.example.bookshop.service;

import com.example.bookshop.domain.Book;
import com.example.bookshop.domain.Order;
import com.example.bookshop.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {
    @Autowired
    private OrdersRepo ordersRepo;
    @Autowired
    private BookService bookService;



    public void addOrder(Long id, String name, Integer quantity, String number) {
        Order order = new Order();
        order.setName(name);
        order.setQuantity(quantity);
        order.setNumber(number);
        order.setBook(bookService.findBookById(id));
        ordersRepo.save(order);
    }

    public Object findAll() {
        return  ordersRepo.findAll();
    }
}
