package com.calendar.calendar.controller;

import com.calendar.calendar.Services.event.EventService;
import com.calendar.calendar.dto.event.EventDayTimeDto;
import com.calendar.calendar.dto.event.EventIdDto;
import com.calendar.calendar.dto.event.EventResponseDto;
import com.calendar.calendar.dto.event.EventSaveDto;
import com.calendar.calendar.dto.users.UserIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    public ResponseEntity<EventResponseDto> createEvent(
            @RequestBody EventSaveDto eventDto) {
        EventResponseDto event = eventService.createEvent(eventDto);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<EventResponseDto>> getAllEvents(@RequestBody UserIdDto userIdDto) {
        Iterable<EventResponseDto> events = eventService.getAllEvents(userIdDto.getId());
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/day")
    public ResponseEntity<Iterable<EventResponseDto>> getEventsInDay(
            @RequestBody EventDayTimeDto eventDayTimeDto) {
        Iterable<EventResponseDto> events = eventService.getEventsInDay(eventDayTimeDto);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }


    @GetMapping("/month")
    public ResponseEntity<Iterable<EventResponseDto>> getEventsInMonth(
            @RequestBody EventDayTimeDto eventDayTimeDto) {
        Iterable<EventResponseDto> events = eventService.getEventsInMonth(eventDayTimeDto);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @DeleteMapping("/{eventId}/delete")
    public ResponseEntity<HttpStatus> deleteEvent(
            @PathVariable Long eventId,
            @RequestBody UserIdDto userIdDto) {
        eventService.deleteEvent(userIdDto, eventId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
