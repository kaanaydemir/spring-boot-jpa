package com.example.mymapperdemo.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDto implements Serializable {
    private final Long id;
    private final String name;
}
