package com.dmenca.spb.manager;

import com.dmenca.spb.dao.UserTagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTagManager {

    @Autowired
    private UserTagDao userTagDao;

    public List<String> getUserTags(Long userId) {
        return userTagDao.getUserTagsById(userId);
    }
}
