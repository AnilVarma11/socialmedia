package com.example.Socialmedia.Repository;

import com.example.Socialmedia.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
