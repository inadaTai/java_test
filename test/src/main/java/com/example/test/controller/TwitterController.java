package com.example.test.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.test.service.TwitterServiceImpl;
 
@RestController
@RequestMapping("api/twitter")
public class TwitterController {
 
    @Autowired
    private TwitterServiceImpl twitterServiceImpl;
     
    @GetMapping("search")
    public List<String> searchTwitter() {
        return twitterServiceImpl.queueTweets();
    }
     
}