package com.example.demo.Mapper;

import com.example.demo.Dto.CreatePostDto;
import com.example.demo.Dto.PostDto;
import com.example.demo.Entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public PostDto toDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public Post toEntity(CreatePostDto postDto) {
        return Post.builder()
                .title(postDto.title)
                .content(postDto.content)
                .build();
    }
}
