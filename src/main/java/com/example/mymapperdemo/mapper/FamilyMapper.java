package com.example.mymapperdemo.mapper;


import com.example.mymapperdemo.dtos.FamilyDto;
import com.example.mymapperdemo.entities.Family;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FamilyMapper {

    Family familyDtoToFamily(FamilyDto familyDto);

    FamilyDto familyToFamilyDto(Family family);
}
