package com.xclone_Project.xclone_backend.model;

import  java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tweets")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_Id",referencedColumnName="id")
    private User user;

    @Column(name = "content")
    private String content;

    @Column(name = "Created_at")
    @NotNull
    private LocalDateTime creationTime;

    @OneToMany(mappedBy = "tweet")
    private List<Like>likes;
    
    @OneToMany(mappedBy = "tweet",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TweetImage>images;

    @ManyToOne
    @JoinColumn(name = "parent_tweet_id")
    private Tweet parentTweet;

    @OneToMany(mappedBy = "parentTweet")
    private List<Tweet> replies;
}
