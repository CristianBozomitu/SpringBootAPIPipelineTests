package com.example.demo.controller;

import com.example.demo.Dto.CreatePostDto;
import com.example.demo.Dto.PostDto;

import com.example.demo.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    //private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplate<PostDto>> getById(@PathVariable Long id) {
        PostDto dto = postService.getPostById(id);
        return ResponseEntity.ok(new ResponseTemplate<>(dto));
    }

//    @GetMapping()
//    public ResponseEntity<ResponseTemplate<List<PostDto>>> getAll(){
//        System.out.println("Hello deployment! Fetching posts...");
//        List<PostDto> dtoList = postRepository.getAll();
//        System.out.println("Here are your posts:");
//        return ResponseEntity.ok(new ResponseTemplate<>(dtoList));
//    }

    @PostMapping()
    public ResponseEntity<ResponseTemplate<PostDto>> createPost(@RequestBody @Valid CreatePostDto postDto) {
        PostDto createdPost = postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseTemplate<>(createdPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(@RequestBody @Valid PostDto postDto) {
        postService.updatePost(postDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
