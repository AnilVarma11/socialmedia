package com.example.Socialmedia.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;

    private String title;
    private String content;
    private String timeStamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-post")
    private User user;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "post-comment")
    private List<Comment> comments;


}
