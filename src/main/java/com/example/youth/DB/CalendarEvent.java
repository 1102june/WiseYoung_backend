package com.example.youth.DB;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.example.youth.DB.User;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CalendarEvent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private LocalDate endDate;
    private LocalDateTime createdAt = LocalDateTime.now();
}

enum EventType { policy, housing }
