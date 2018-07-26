package com.example.bookshop.repo;

import com.example.bookshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo  extends JpaRepository<User,Long> {
User findByUsername(String username);
User findByEmail(String email);


}
