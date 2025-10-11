package com.calendar.calendar.Services.event;

import com.calendar.calendar.Entities.Event;
import com.calendar.calendar.dto.event.EventResponseDto;
import com.calendar.calendar.dto.event.EventSaveDto;
import com.calendar.calendar.mappers.EventMapper;
import com.calendar.calendar.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public EventResponseDto createEvent(EventSaveDto eventDto) {
        System.out.println(eventDto.getTitle());
        Event event = eventRepository.save(eventMapper.createDtoToEntity(eventDto));
        return eventMapper.entityToEventResponseDto(event);
    }
}
