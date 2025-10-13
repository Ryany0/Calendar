package com.calendar.calendar.Services.event;

import com.calendar.calendar.Entities.Event;
import com.calendar.calendar.dto.event.EventDayTimeDto;
import com.calendar.calendar.dto.event.EventResponseDto;
import com.calendar.calendar.dto.event.EventSaveDto;
import com.calendar.calendar.dto.users.UserIdDto;
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
        System.out.println(event.toString());
        return eventMapper.entityToEventResponseDto(event);
    }

    @Override
    public List<EventResponseDto> getAllEvents(Long id) {
        List<Event> events = eventRepository.findAllEventsByUserId(id);
        System.out.println(events.toString());
        return eventMapper.entityListToEventResponseDtoList(events);
    }

    @Override
    public Iterable<EventResponseDto> getEventsInDay(EventDayTimeDto eventDayTimeDto) {
        LocalDate date = LocalDate.of(eventDayTimeDto.getYear(), eventDayTimeDto.getMonth(), eventDayTimeDto.getDay());
        List<Event> events = eventRepository.findEventsInDay(eventDayTimeDto.getId(), date);
        return eventMapper.entityListToEventResponseDtoList(events);
    }

    @Override
    public Iterable<EventResponseDto> getEventsInMonth(EventDayTimeDto eventDayTimeDto) {
        LocalDate startOfMonth = LocalDate.of(eventDayTimeDto.getYear(), eventDayTimeDto.getMonth(), 1);
        LocalDate endOfMonth = startOfMonth.plusMonths(1);
        List<Event> events = eventRepository.findEventsInMonth(eventDayTimeDto.getId(), startOfMonth, endOfMonth);
        return eventMapper.entityListToEventResponseDtoList(events);
    }

    @Override
    public void deleteEvent(UserIdDto userIdDto, Long eventId) {
        eventRepository.deleteEventById(userIdDto.getId(), eventId);
    }
}
