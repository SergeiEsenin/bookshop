package com.example.bookshop.service;

import com.example.bookshop.config.WebSecurityConfig;
import com.example.bookshop.domain.Role;
import com.example.bookshop.domain.User;
import com.example.bookshop.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService  implements UserDetailsService {
@Autowired
private UsersRepo usersRepo;
@Autowired
private WebSecurityConfig webSecurityConfig;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

    User user = usersRepo.findByUsername(s);

        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }


    private void saveUser(User user){
        usersRepo.save(user);
    }
    private User findUserByUsername(String username){
        return  usersRepo.findByUsername(username);
    }


    public boolean addUser(String username, String password, String password2, String email) {
        User userFromDB= findUserByUsername(username);
        User userFromDBByEmail =findUserByEmail(email);
        if(userFromDB==null||password.equals(password2)||userFromDBByEmail==null){
            User user = new User();
            user.setActive(true);
            user.setUsername(username);
            user.setRoles(Collections.singleton(Role.USER));
            user.setPassword(webSecurityConfig.passwordEncoder.encode(password));
            user.setEmail(email);
            saveUser(user);
            return  true;
    }else  return false;
    }
    private User findUserByEmail(String email){
        return  usersRepo.findByEmail(email);
    }
}
