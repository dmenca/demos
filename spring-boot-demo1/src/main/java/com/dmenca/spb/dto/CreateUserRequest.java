package com.dmenca.spb.dto;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String username;

    private Integer age;

    private String email;

    private String password;

    // 构造方法、getter 和 setter 省略
}
