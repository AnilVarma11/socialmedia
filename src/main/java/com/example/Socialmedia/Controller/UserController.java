package com.example.Socialmedia.Controller;

import com.example.Socialmedia.Entity.Post;
import com.example.Socialmedia.Entity.User;
import com.example.Socialmedia.Service.PostService;
import com.example.Socialmedia.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // Get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Fetching all users");
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Get user by ID
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        logger.info("Fetching user by ID: {}", id);
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new user
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        logger.info("Adding a new user: {}", user.getUserName());
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // soft deletes a user based on their id
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> softDeleteCustomer(@PathVariable Integer userId) {
        logger.info("soft deleting a user with id");
        userService.softDeleteCustomer(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
