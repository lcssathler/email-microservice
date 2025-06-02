package com.ms.user.controller;

import com.ms.user.dto.UserRecordDTO;
import com.ms.user.model.User;
import com.ms.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRecordDTO userRecordDTO) {
        User user = new User();
        user.setName(userRecordDTO.name());
        user.setEmail(userRecordDTO.email());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUsers());
    }
}
