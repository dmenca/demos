package com.dmenca.spb.dao;

import com.dmenca.spb.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserTagDao {

    private static final Map<Long, List<String>> userTags = new HashMap<>();

    public List<String> getUserTagsById(Long id) {
        return userTags.get(id);
    }

}
