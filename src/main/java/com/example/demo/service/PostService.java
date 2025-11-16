package com.example.demo.service;

import com.example.demo.Dto.CreatePostDto;
import com.example.demo.Dto.PostDto;
import com.example.demo.Entity.Post;
import com.example.demo.Mapper.PostMapper;
import com.example.demo.Repository.IPostsRepository;
import com.example.demo.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public PostDto createPost(CreatePostDto postDto) {
        var post = postsRepository.save(postMapper.toEntity(postDto));
        return postMapper.toDto(post);
    }

    @Transactional
    public void deletePost(Long id){
        int deletedCount = postsRepository.deletePostById(id);
        if(deletedCount == 0){
            throw new NotFoundException("Post not found");
        }
    }

    public void updatePost(PostDto postDto){
        Post post = postsRepository.findById(postDto.id).orElseThrow(() -> new NotFoundException("Post not found"));

        post.setTitle(postDto.title);
        post.setContent(postDto.content);
        postsRepository.save(post);
    }
}
