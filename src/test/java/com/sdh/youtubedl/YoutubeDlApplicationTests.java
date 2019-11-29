package com.sdh.youtubedl;

import com.sdh.youtubedl.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RedisConfig.class)
class YoutubeDlApplicationTests {

    @Autowired
    RedisTemplate<String,String> template;
    @Test
    void contextLoads() {
        template.opsForZSet().add("ztest","aaa",1);
        long size = template.opsForZSet().size("ztest");
        System.out.println(size);
    }

}
