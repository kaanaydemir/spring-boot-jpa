package com.example.mymapperdemo.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String name;
    private final Set<PostDto> posts;
}
