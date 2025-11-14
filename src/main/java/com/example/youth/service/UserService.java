package com.example.youth.service;

import com.example.youth.DB.User;
import com.example.youth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // 자동 주입

    public String registerUser(User user) {
        // 이메일 중복 확인
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email already exists";
        }

        // DB에 저장
        userRepository.save(user);
        return "회원가입 성공";
    }

    public User getUserByUid(String uid) {
        return userRepository.findById(uid).orElse(null); // UID로 사용자 조회
    }
}