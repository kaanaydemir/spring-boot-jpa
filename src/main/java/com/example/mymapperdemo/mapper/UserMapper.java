package com.example.mymapperdemo.mapper;

import com.example.mymapperdemo.dtos.UserDto;
import com.example.mymapperdemo.entities.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromUserDto(UserDto userDto, @MappingTarget User user);

    @AfterMapping
    default void linkPosts(@MappingTarget User user) {
        if(user.getPosts() != null){
            user.getPosts ()
                    .forEach (post -> post.setUser (user));
        }

    }


}
