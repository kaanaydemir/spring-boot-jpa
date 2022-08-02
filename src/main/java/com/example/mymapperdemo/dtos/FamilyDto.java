package com.example.mymapperdemo.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class FamilyDto implements Serializable {
    private final String fatherName;
    private final String motherName;
}
