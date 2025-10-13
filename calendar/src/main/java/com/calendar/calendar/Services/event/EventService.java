package com.calendar.calendar.Services.event;

import com.calendar.calendar.dto.event.EventDayTimeDto;
import com.calendar.calendar.dto.event.EventResponseDto;
import com.calendar.calendar.dto.event.EventSaveDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface EventService {
    EventResponseDto createEvent(EventSaveDto eventDto);

    Iterable<EventResponseDto> getAllEvents(Long id);

    Iterable<EventResponseDto> getEventsInDay(EventDayTimeDto eventDayTimeDto);

    Iterable<EventResponseDto> getEventsInMonth(EventDayTimeDto eventDayTimeDto);
}
