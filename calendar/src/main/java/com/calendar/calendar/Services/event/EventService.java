package com.calendar.calendar.Services.event;

import com.calendar.calendar.dto.event.EventResponseDto;
import com.calendar.calendar.dto.event.EventSaveDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EventService {
    EventResponseDto createEvent(EventSaveDto eventDto);

    Iterable<EventResponseDto> getAllEvents(Long id);

    Iterable<EventResponseDto> getEventsInDay(Long id, LocalDate date);
}
