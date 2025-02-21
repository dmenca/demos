package com.dmenca.spb.service.impl;

import com.dmenca.spb.dto.CreateUserRequest;
import com.dmenca.spb.dto.LabelObjectDTO;
import com.dmenca.spb.dto.UserInfoDTO;
import com.dmenca.spb.manager.UserManager;
import com.dmenca.spb.manager.UserTagManager;
import com.dmenca.spb.manager.UserAddressManager;
import com.dmenca.spb.model.Address;
import com.dmenca.spb.model.User;
import com.dmenca.spb.service.LabelObjectService;
import com.dmenca.spb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserManager userManager;

    @Autowired
    private UserAddressManager userAddressManager;

    @Autowired
    private UserTagManager userTagManager;

    @Autowired
    private LabelObjectService labelObjectService;

    public User getUserById(Long userId) {
        // 业务逻辑封装
        return userManager.getUserById(userId);
    }

    @Override
    public void update(User user) {
        userManager.updateUser(user);
    }

    public UserInfoDTO getUserFullInfo(Long userId){
        // 1. 获取用户基础信息
        User user = userManager.getUserById(userId);
        if (user == null) {
            return null; // 用户不存在，直接返回
        }

        // 2. 获取用户地址信息
        List<Address> addresses = userAddressManager.getUserAddresses(userId);

        // 3. 获取用户标签信息
        List<String> tags = userTagManager.getUserTags(userId);

        // 4. 获取其他service的label数据
        List<LabelObjectDTO> labelObjectsByObjectId = labelObjectService.getLabelObjectsByObjectId(String.valueOf(userId));

        // 4. 组装数据
        return new UserInfoDTO(user, addresses, tags,labelObjectsByObjectId);
    }

    @Override
    public User add(CreateUserRequest createUserRequest) {
        // 1. 调用 UserManager 层创建用户
        User user = userManager.createUser(createUserRequest);
        return user;
    }
}
