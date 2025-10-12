package com.calendar.calendar.Services.event;

import com.calendar.calendar.Entities.Event;
import com.calendar.calendar.dto.event.EventResponseDto;
import com.calendar.calendar.dto.event.EventSaveDto;
import com.calendar.calendar.mappers.EventMapper;
import com.calendar.calendar.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
        Event event = eventRepository.save(eventMapper.createDtoToEntity(eventDto));
        return eventMapper.entityToEventResponseDto(event);
    }

    @Override
    public List<EventResponseDto> getAllEvents(Long id) {
        List<Event> events = eventRepository.findAllEventsByUserId(id);
        return eventMapper.entityListToEventResponseDtoList(events);
    }

    @Override
    public Iterable<EventResponseDto> getEventsInDay(Long id, LocalDate date) {
        List<Event> events = eventRepository.getEventsInDayByUserId(id, date);
        return eventMapper.entityListToEventResponseDtoList(events);
    }
}
