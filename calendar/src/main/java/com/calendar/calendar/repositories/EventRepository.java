package com.calendar.calendar.repositories;

import com.calendar.calendar.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(
            value = "SELECT * FROM event WHERE users_id = ?",
            nativeQuery = true
    )
    List<Event> findAllEventsByUserId(Long id);

    @Query(
            value = "SELECT * FROM event WHERE users_id = ? AND task_date = ?",
            nativeQuery = true
    )
    List<Event> findEventsInDay(Long id, LocalDate date);

    @Query(
            value = "SELECT * FROM event WHERE users_id = ? AND task_date >= ? AND task_date < ?",
            nativeQuery = true
    )
    List<Event> findEventsInMonth(Long id, LocalDate startOfMonth, LocalDate endOfMonth);

    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM event WHERE users_id = ? AND id = ?",
            nativeQuery = true
    )
    void deleteEventById(Long userId, Long eventId);
}
