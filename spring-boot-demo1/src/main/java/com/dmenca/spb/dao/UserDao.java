package com.dmenca.spb.dao;

import com.dmenca.spb.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    private static final Map<Long, User> userDb = new HashMap<>();

    public User getUserById(Long id) {
        return userDb.get(id);
    }

    public void save(User user) {
        userDb.put(user.getId(), user);
    }

}
