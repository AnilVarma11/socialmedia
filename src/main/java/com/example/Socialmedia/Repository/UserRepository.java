package com.example.Socialmedia.Repository;

import com.example.Socialmedia.Entity.User;
import com.example.Socialmedia.Enum.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByStatusNot(UserStatus status);
}
