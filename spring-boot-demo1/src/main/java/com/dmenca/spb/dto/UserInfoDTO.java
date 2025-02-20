package com.dmenca.spb.dto;

import com.dmenca.spb.model.Address;
import com.dmenca.spb.model.User;
import lombok.Data;

import java.util.List;

@Data
public class UserInfoDTO {
    private Long userId;
    private String username;
    private List<Address> addresses;
    private List<String> tags;

    public UserInfoDTO(User user, List<Address> addresses, List<String> tags) {
        this.userId = user.getId();
        this.username = user.getUsername();
        this.addresses = addresses;
        this.tags = tags;
    }
}
