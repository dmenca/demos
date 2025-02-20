package com.dmenca.spb.manager;

import com.dmenca.spb.dao.UserDao;
import com.dmenca.spb.dto.CreateUserRequest;
import com.dmenca.spb.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class UserManager {
    private static final String USER_CACHE_KEY_PREFIX = "user:";
    private static final long CACHE_EXPIRATION = 10; // 10分钟缓存过期

    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public User getUserById(Long userId) {
        String cacheKey = USER_CACHE_KEY_PREFIX + userId;

        // 先查询缓存
        String userJson = redisTemplate.opsForValue().get(cacheKey);
        if (userJson != null) {
            try {
                return objectMapper.readValue(userJson, User.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        // 缓存未命中，查询数据库
        User user = userDao.getUserById(userId);
        if (user != null) {
            try {
                redisTemplate.opsForValue().set(cacheKey, objectMapper.writeValueAsString(user), CACHE_EXPIRATION, TimeUnit.MINUTES);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public User createUser(CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // 实际项目中，密码需要加密处理
        user.setEmail(request.getEmail());
        user.setAge(request.getAge());
        user.setId(new Random().nextLong());
        userDao.save(user); // 假设使用 JPA 的 save 方法
        return user;
    }

    public void updateUser(User user) {
        userDao.save(user);
        redisTemplate.delete(USER_CACHE_KEY_PREFIX + user.getId()); // 删除缓存
    }
}
