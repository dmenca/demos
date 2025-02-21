package com.dmenca.spb.controller;

import com.dmenca.spb.dto.CreateUserRequest;
import com.dmenca.spb.dto.CreateUserResponse;
import com.dmenca.spb.dto.UserInfoDTO;
import com.dmenca.spb.model.User;
import com.dmenca.spb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("")
    public ResponseEntity<CreateUserResponse> add(@RequestBody CreateUserRequest request) {
        User user = userService.add(request);
        CreateUserResponse createUserResponse = new CreateUserResponse();
        return ResponseEntity.ok(createUserResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok("User updated");
    }

    @GetMapping("/{id}/full-info")
    public ResponseEntity<UserInfoDTO> getUserFullInfo(@PathVariable Long id) {
        if (id<=0){
            return ResponseEntity.badRequest().build();
        }
        UserInfoDTO userInfo = userService.getUserFullInfo(id);
        if (userInfo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userInfo);
    }
}