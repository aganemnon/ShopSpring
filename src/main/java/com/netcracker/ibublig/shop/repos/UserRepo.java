package com.netcracker.ibublig.shop.repos;

import com.netcracker.ibublig.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
