package com.example.demo.service;

import com.example.demo.Dto.CreatePostDto;
import com.example.demo.Dto.PostDto;
import com.example.demo.Entity.Post;
import com.example.demo.Mapper.PostMapper;
import com.example.demo.Repository.IPostsRepository;
import com.example.demo.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final IPostsRepository postsRepository;
    public final PostMapper postMapper;

    public PostDto getPostById(Long id) {
        return postsRepository.findById(id)
                .map(post -> PostDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .build())
                .orElseThrow(() -> new NotFoundException("Post not found"));
    }

    public List<PostDto> getPosts(){
        return postsRepository.findAll().stream()
                .map(postMapper::toDto)
                .toList();
    }

    public PostDto createPost(CreatePostDto postDto) {
        var post = postsRepository.save(postMapper.toEntity(postDto));
        return postMapper.toDto(post);
    }

    public void deletePost(Long id){
        postsRepository.findById(id).orElseThrow(() -> new NotFoundException("Post not found"));
        postsRepository.deleteById(id);
    }

    public void updatePost(PostDto postDto){
        Post post = postsRepository.findById(postDto.id).orElseThrow(() -> new NotFoundException("Post not found"));

        post.setTitle(postDto.title);
        post.setContent(postDto.content);
        postsRepository.save(post);
    }
}
