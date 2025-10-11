package com.calendar.calendar.mappers;

import com.calendar.calendar.Entities.Event;
import com.calendar.calendar.dto.event.EventResponseDto;
import com.calendar.calendar.dto.event.EventSaveDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    Event createDtoToEntity(EventSaveDto eventDto);

    EventResponseDto entityToEventResponseDto(Event event);
}
