package com.example.youth.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseAuthService {

    public FirebaseAuthService() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/firebase-admin.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
    }

    // Firebase ID Token 검증
    public FirebaseToken verifyToken(String idToken) {
        try {
            return FirebaseAuth.getInstance().verifyIdToken(idToken);
        } catch (FirebaseAuthException e) {
            // 예외 처리
            System.out.println("Token verification failed: " + e.getMessage());
            throw new RuntimeException("Firebase Token Verification Failed", e); // 예외를 던지거나 처리
        }
    }
}