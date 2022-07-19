package com.example.mymapperdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PostDto implements Serializable {
    private final Long id;
    private final String content;
    private final LocalDateTime createdDate;
    private final Long userId;
}
