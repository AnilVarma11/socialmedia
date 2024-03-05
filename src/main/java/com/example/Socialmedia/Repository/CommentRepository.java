package com.example.Socialmedia.Repository;

import com.example.Socialmedia.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
