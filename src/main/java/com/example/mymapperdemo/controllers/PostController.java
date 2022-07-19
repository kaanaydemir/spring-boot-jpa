package com.example.mymapperdemo.controllers;


import com.example.mymapperdemo.dtos.PostDto;
import com.example.mymapperdemo.entities.Post;
import com.example.mymapperdemo.mapper.PostMapperImpl;
import com.example.mymapperdemo.repositories.PostRepository;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1")
public class PostController {

    private final PostMapperImpl postMapperImpl;

    private final PostRepository postRepository;

    public PostController(PostMapperImpl postMapperImpl, PostRepository postRepository) {
        this.postMapperImpl = postMapperImpl;
        this.postRepository = postRepository;
    }

    @GetMapping(value = "/post")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<Post> posts = postRepository.findAll ();
        List<PostDto> postDtos = posts.stream ().map (postMapperImpl::postToPostDto).collect(Collectors.toList());
        return  ResponseEntity.ok (postDtos);
    }

    @GetMapping(value = "/post/{id}")
    public ResponseEntity<PostDto> getPostById(Long id){
        Post post = postRepository.findById (id).orElseThrow (EntityNotFoundException::new);
        return  ResponseEntity.ok (postMapperImpl.postToPostDto (post));
    }

    @PostMapping(value = "/post")
    public ResponseEntity<PostDto> savePost(@RequestBody @Valid @NonNull PostDto postDto){
        Post post = postMapperImpl.postDtoToPost (postDto);
        return ResponseEntity.ok (postMapperImpl.postToPostDto (postRepository.save (post)));
    }
}
