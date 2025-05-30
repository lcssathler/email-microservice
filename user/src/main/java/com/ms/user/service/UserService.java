package com.ms.user.service;

import com.ms.user.model.User;
import com.ms.user.publishers.UserPublisher;
import com.ms.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPublisher userPublisher;

    @Transactional
    public User saveUser(User user) {
        User userSaved = userRepository.save(user);
        userPublisher.publishMessenger(userSaved);
        return userSaved;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
