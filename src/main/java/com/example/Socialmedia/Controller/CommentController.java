package com.example.Socialmedia.Controller;

import com.example.Socialmedia.Entity.Comment;
import com.example.Socialmedia.Service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    // Get all comments
    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        logger.info("Fetching all the comments");
        List<Comment> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    // Get comment by ID
    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        logger.info("Fetching a comment by ID: {}", id);
        Comment comment = commentService.getCommentsById(id);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new comment
    @PostMapping("/comments")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        logger.info("Adding a new comment: {}");
        Comment newComment = commentService.addComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }
}
