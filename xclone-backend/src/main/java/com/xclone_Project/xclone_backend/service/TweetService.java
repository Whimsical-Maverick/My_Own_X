package com.xclone_Project.xclone_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xclone_Project.xclone_backend.repository.TweetRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository tweetRepository;

    void add_tweet(String userId, String content, List<String> imageUrls)
    {
        tweetRepository.addTweet(userId, content, imageUrls);
    }

    void delete_tweet(Long tweetId)
    {
        tweetRepository.deleteById(tweetId);
    }

    void like_tweet(Long tweetId, String userId)
    {
        tweetRepository.likeTweet(tweetId, userId);
    }
}
