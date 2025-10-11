package com.calendar.calendar.Services.event;

import com.calendar.calendar.dto.event.EventResponseDto;
import com.calendar.calendar.dto.event.EventSaveDto;
import org.springframework.stereotype.Service;

@Service
public interface EventService {
    EventResponseDto createEvent(EventSaveDto eventDto);
}
