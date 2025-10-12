package com.calendar.calendar.controller;

import com.calendar.calendar.Services.event.EventService;
import com.calendar.calendar.dto.event.EventResponseDto;
import com.calendar.calendar.dto.event.EventSaveDto;
import com.calendar.calendar.dto.users.UserIdDto;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/{month}")
//    public ResponseEntity<EventResponseDto> getTasksInMonth(
//            @PathVariable int month,
//            @RequestBody EventSaveDto) {
//
//        return new ResponseEntity<>()
//    }


}
