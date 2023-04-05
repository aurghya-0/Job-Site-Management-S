package com.example.JobManagementSite.dao;

import com.example.JobManagementSite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUserName(String username);

    Boolean existsByUserName(String username);

    Boolean existsByUserEmail(String email);
}
