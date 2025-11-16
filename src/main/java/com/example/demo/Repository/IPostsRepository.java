package com.example.demo.Repository;

import com.example.demo.Entity.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostsRepository extends JpaRepository<Post, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Post p WHERE p.id = :id")
    int deletePostById(@Param("id") Long id);
}
