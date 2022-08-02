package com.example.mymapperdemo.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
public class Family {

    @Column(name = "father_name",table = "family")
    private String fatherName;

    @Column(name = "mother_name",table = "family")
    private String motherName;
}
