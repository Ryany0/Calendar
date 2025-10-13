package com.calendar.calendar.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDayTimeDto {
    private Long id;
    private int year;
    private int month;
    private int day;
}
