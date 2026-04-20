package com.xclone_Project.xclone_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xclone_Project.xclone_backend.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> 
{
       
}