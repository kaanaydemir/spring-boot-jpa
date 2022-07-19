package com.example.mymapperdemo.repositories;

import com.example.mymapperdemo.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}