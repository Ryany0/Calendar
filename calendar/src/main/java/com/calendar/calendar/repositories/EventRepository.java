package com.calendar.calendar.repositories;

import com.calendar.calendar.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(
            value = "SELECT * FROM event WHERE users_id = ?",
            nativeQuery = true
    )
    List<Event> findAllEventsByUserId(Long id);
}
