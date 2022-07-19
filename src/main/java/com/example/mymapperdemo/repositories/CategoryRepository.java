package com.example.mymapperdemo.repositories;

import com.example.mymapperdemo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}