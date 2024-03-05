package com.example.Socialmedia.Controller;

import com.example.Socialmedia.Entity.Post;
import com.example.Socialmedia.Service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    // Get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        logger.info("Fetching all posts");
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Get post by ID
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        logger.info("Fetching a post by ID: {}", id);
        Post post = postService.getPostById(id);
        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new post
    @PostMapping("/posts")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        logger.info("Adding a new post: {}");
        Post newPost = postService.addPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }
}
