package com.xclone_Project.xclone_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xclone_Project.xclone_backend.repository.TweetRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository tweetRepository;

    
}
