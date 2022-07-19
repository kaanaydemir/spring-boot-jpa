package com.example.mymapperdemo.repositories;

import com.example.mymapperdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}