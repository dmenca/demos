package com.dmenca.spb.dto;

import com.dmenca.spb.model.Address;
import com.dmenca.spb.model.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDetailDTO {
    private String name;
    private Integer age;
    private List<Address> addresses; // 最近订单
}
