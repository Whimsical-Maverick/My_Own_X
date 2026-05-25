package com.xclone_Project.xclone_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xclone_Project.xclone_backend.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> 
{
       void addTweet(String userId, String content, List<String> imageUrls);
       void deleteById(Long tweetId);
       void likeTweet(Long tweetId, String userId);
}