package com.example.demo.Config;

import com.example.demo.Entity.Post;
import com.example.demo.Mapper.PostMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PostSeeder {
//    @Bean
//    public PostRepository seedPosts(PostMapper mapper) {
//        Post post1 = Post.builder()
//                .id(1L)
//                .title("First Post")
//                .content("This is the content of the first post.")
//                .build();
//        Post post2 = Post.builder()
//                .id(2L)
//                .title("Second Post")
//                .content("This is the content of the second post.")
//                .build();
//        Post post3 = Post.builder()
//                .id(3L)
//                .title("Third Post")
//                .content("This is the content of the third post.")
//                .build();
//
//        System.out.println("Seeding posts...");
//        return new PostRepository(new ArrayList<>(List.of(post1, post2, post3)), mapper);
//    }
}
