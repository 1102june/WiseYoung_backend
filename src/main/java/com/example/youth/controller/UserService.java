package com.example.youth.controller;

import com.example.youth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.youth.DB.User;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUid(String uid) {
        return userRepository.findById(uid).orElse(null);  // UID로 사용자 조회
    }
}
