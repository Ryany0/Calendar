package com.calendar.calendar.Services.event;

import com.calendar.calendar.dto.event.EventDayTimeDto;
import com.calendar.calendar.dto.event.EventResponseDto;
import com.calendar.calendar.dto.event.EventSaveDto;
import com.calendar.calendar.dto.event.EventUpdateDto;
import com.calendar.calendar.dto.users.UserIdDto;
import org.springframework.stereotype.Service;

@Service
public interface EventService {
    EventResponseDto createEvent(EventSaveDto eventDto);

    Iterable<EventResponseDto> getAllEvents(Long id);

    Iterable<EventResponseDto> getEventsInDay(EventDayTimeDto eventDayTimeDto);

    Iterable<EventResponseDto> getEventsInMonth(EventDayTimeDto eventDayTimeDto);

    void deleteEvent(UserIdDto userIdDto, Long eventId);

    EventResponseDto updateEvent(Long eventId, EventUpdateDto eventUpdateDto);
}
