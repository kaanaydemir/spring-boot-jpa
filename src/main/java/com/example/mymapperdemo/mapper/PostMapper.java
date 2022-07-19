package com.example.mymapperdemo.mapper;

import com.example.mymapperdemo.dtos.PostDto;
import com.example.mymapperdemo.entities.Post;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostMapper {

    @Mapping (source = "userId",target = "user.id")
    Post postDtoToPost(PostDto postDto);

    @Mapping (source = "user.id",target = "userId")
    PostDto postToPostDto(Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Post updatePostFromPostDto(PostDto postDto, @MappingTarget Post post);
}
