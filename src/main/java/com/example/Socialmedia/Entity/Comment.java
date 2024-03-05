package com.example.Socialmedia.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;
    private String content;
    private String timeStamp;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    @JsonBackReference(value = "post-comment")
    private Post post;

}
