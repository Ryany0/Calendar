package com.calendar.calendar.repositories;

import com.calendar.calendar.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
