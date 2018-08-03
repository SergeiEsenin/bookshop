package com.example.bookshop.controller;

import com.example.bookshop.domain.Book;
import com.example.bookshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
@Autowired
private OrderService orderService;

    @GetMapping("/order/{book}")
    public String about(@PathVariable Book book, Model model){

        model.addAttribute("book",book);
        return "order";

    }


    @PostMapping ("/order/{id}")
    public String buy   (@PathVariable Long id,
                         @RequestParam("buyerName") String name,
                         @RequestParam Integer quantity,
                         @RequestParam String number){
        orderService.addOrder(id,name,quantity,number);

        return "redirect:/";

    }
    @GetMapping("/order/list")
    public String listOfOrders (Model model){
        model.addAttribute("orders",orderService.findAll());
        return "orderList";
    }

    @PostMapping("/order/list")
    public String changingStatus (Model model){
        model.addAttribute("orders",orderService.findAll());
        return "orderList";
    }

}
