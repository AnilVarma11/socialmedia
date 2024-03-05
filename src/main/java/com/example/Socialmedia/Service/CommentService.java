package com.example.Socialmedia.Service;

import com.example.Socialmedia.Entity.Comment;
import com.example.Socialmedia.Entity.Post;
import com.example.Socialmedia.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getCommentsById(Integer id) {
        return commentRepository.findById(id).orElse(null);
    }

}
