package com.example.bookshop.service;

import com.example.bookshop.domain.Order;
import com.example.bookshop.domain.Status;
import com.example.bookshop.repo.OrdersRepo;
import com.example.bookshop.util.RunningSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrdersRepo ordersRepo;
    @Autowired
    private BookService bookService;



    public void addOrder(Long id, String name, Integer quantity, String number) {
        String details=name+" "+quantity+" "+number;
        Order order = new Order();
        order.setName(name);
        order.setQuantity(quantity);
        order.setNumber(number);
        order.setStatus(Status.NEW.toString());
        order.setBook(bookService.findBookById(id));
        RunningSS.sendMsg(details);
        ordersRepo.save(order);
    }

    public Object findAll() {
        return  ordersRepo.findAll();
    }

    public void changeStatus(Map<String,String> form,Order order) {
        Set<String> statuses = Arrays.stream(Status.values()).map(Status::name).collect(Collectors.toSet());
        order.setStatus(Status.NEW.toString());
        for (String key : form.keySet()) {
            if (statuses.contains(key)) {
                order.setStatus(key);

            }
            ordersRepo.save(order);
        }
    }
}
