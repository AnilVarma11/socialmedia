package com.example.Socialmedia.Service;

import com.example.Socialmedia.Entity.User;
import com.example.Socialmedia.Enum.UserStatus;
import com.example.Socialmedia.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void softDeleteCustomer(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        user.setStatus(UserStatus.DELETED);
        userRepository.save(user);
    }


}
