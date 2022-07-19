package com.example.mymapperdemo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "categories")
    private Set<Post> posts = new LinkedHashSet<> ();
}
