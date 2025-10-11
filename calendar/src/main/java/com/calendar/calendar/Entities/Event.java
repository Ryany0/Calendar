package com.calendar.calendar.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "event")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime startTime;
    private LocalTime endTime;

    @Column(nullable = false)
    private LocalDate taskDate;

    private Boolean completed = false;

    @Column(nullable = false)
    private String Title;

    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    @Column(nullable = false)
    private Users users;


}
