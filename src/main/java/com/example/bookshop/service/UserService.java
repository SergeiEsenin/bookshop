package com.example.bookshop.service;

import com.example.bookshop.domain.User;
import com.example.bookshop.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService  implements UserDetailsService {
@Autowired
private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

    User user = usersRepo.findByUsername(s);

        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }


}
