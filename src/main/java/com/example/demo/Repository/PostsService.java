package com.example.demo.Repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PostsService {
    private final IPostsRepository postsRepository;

    public void deleteById(Long id) throws RuntimeException {
       postsRepository.deleteById(id);
       throw new RuntimeException();
    }
}
