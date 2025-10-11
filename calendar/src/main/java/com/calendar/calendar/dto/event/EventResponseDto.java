package com.calendar.calendar.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventResponseDto {

    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate taskDate;
    private Boolean completed;
    private String title;
    private String content;

}
