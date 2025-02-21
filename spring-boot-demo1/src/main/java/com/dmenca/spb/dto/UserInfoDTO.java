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
    private List<LabelObjectDTO> labels;

    public UserInfoDTO(User user, List<Address> addresses, List<String> tags,List<LabelObjectDTO> labels) {
        this.userId = user.getId();
        this.username = user.getUsername();
        this.addresses = addresses;
        this.tags = tags;
        this.labels = labels;
    }
}
