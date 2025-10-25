package com.example.demo.controller;

import com.example.demo.Dto.PostDto;
import com.example.demo.Entity.Post;
import com.example.demo.Repository.PostRepository;
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

    private final PostRepository postRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplate<PostDto>> getById(@PathVariable Long id) {
        PostDto dto = postRepository.getById(id);
        return ResponseEntity.ok(new ResponseTemplate<>(dto));
    }

    @GetMapping()
    public ResponseEntity<ResponseTemplate<List<PostDto>>> getAll(){
        System.out.println("Hello deployment! Fetching posts...");
        List<PostDto> dtoList = postRepository.getAll();
        System.out.println("Here are your posts:");
        return ResponseEntity.ok(new ResponseTemplate<>(dtoList));
    }

    @PostMapping()
    public ResponseEntity<ResponseTemplate<PostDto>> createPost(@RequestBody @Valid PostDto postDto) {
        PostDto createdPost = postRepository.create(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseTemplate<>(createdPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(@RequestBody @Valid PostDto postDto) {
        postRepository.update(postDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
