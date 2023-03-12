package com.myapp.springredisdemo.repository;

import com.myapp.springredisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER";

    public void saveUser(User user) {
        redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);
    }

    public List<User> getAllUsers() {
        return redisTemplate.opsForHash().values(KEY);
    }
}
