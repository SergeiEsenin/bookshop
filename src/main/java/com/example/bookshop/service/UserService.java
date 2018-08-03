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

import java.util.*;
import java.util.stream.Collectors;

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
        if(userFromDB==null&&password.equals(password2)&&userFromDBByEmail==null){
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


    public List<User> findAll() {
      return   usersRepo.findAll();
    }

    public void changeStatus(User user,Map<String,String> form) {
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if(roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
                System.out.println(key);
            }
        }


        usersRepo.save(user);
    }

    public void updateProfile(User user, String password,String password2, String email) {
        if(password.equals(password2)){
            user.setPassword(webSecurityConfig.passwordEncoder.encode(password));
        }
        if(usersRepo.findByEmail(email)==null){
            user.setEmail(email);
        }
        usersRepo.save(user);

    }
}
