package com.dmenca.spb.service;

import com.dmenca.spb.dto.CreateUserRequest;
import com.dmenca.spb.dto.UserDetailDTO;
import com.dmenca.spb.dto.UserInfoDTO;
import com.dmenca.spb.model.User;

public interface UserService {


    User getUserById(Long userId);

    void update(User user);

    UserInfoDTO getUserFullInfo(Long userId);

    User add(CreateUserRequest createUserRequest);

}
