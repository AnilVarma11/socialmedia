package com.example.Socialmedia.Service;

import com.example.Socialmedia.Entity.Post;
import com.example.Socialmedia.Entity.User;
import com.example.Socialmedia.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }



}
