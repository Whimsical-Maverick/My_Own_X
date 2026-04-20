package com.xclone_Project.xclone_backend.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "email")
    @NotNull
    private String emailId;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "bio")
    private String bio;

    @Column(name = "profile_picture")
    private String imageUrl;

    @Column(name = "created_at")
    @NotNull
    private LocalDateTime creationTime;

    @OneToMany(mappedBy = "user")
    private List<Tweet>tweets;

    @OneToMany(mappedBy = "user")
    private List<Like>likes;

    @OneToMany(mappedBy = "followers")
    private List<Follow> followers;

    @OneToMany(mappedBy = "following")
    private List<Follow> following;

    
}
