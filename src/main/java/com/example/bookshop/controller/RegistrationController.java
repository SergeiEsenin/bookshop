package com.example.bookshop.controller;

import com.example.bookshop.config.WebSecurityConfig;
import com.example.bookshop.domain.Role;
import com.example.bookshop.domain.User;
import com.example.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;


    @GetMapping
    public String registration(){return "registration";}


@PostMapping
    public String addUser(@RequestParam String username, @RequestParam String password, @RequestParam String password2,
                          @RequestParam String email){

       boolean flag= userService.addUser(username,password,password2,email);

       if(flag){
        return "redirect:/login";}
        else return "registration";
}

}
