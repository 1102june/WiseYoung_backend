package com.example.youth.DB;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.example.youth.DB.User;
import com.example.youth.DB.Policy;
import com.example.youth.DB.Housing;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Notification {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime sendDate;
    private Boolean isRead = false;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    @ManyToOne
    @JoinColumn(name = "housing_id")
    private Housing housing;
}
