package com.sdh.youtubedl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/down")
public class YoutubeDownloaderController {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @PostMapping
    public ResponseEntity<?> downloadVideo(@RequestParam List<String> videos) {
        for( String video: videos) {
            System.out.println("key: {}".replace("{}", video));
            redisTemplate.opsForList().leftPush("pending", video);
        }
        return ResponseEntity.ok(null);
    }
}
