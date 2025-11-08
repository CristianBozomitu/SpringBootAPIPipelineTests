package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String title;
    @Column(nullable = false, length = 255)
    private String content;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
