package com.calendar.calendar.Entities;

import com.calendar.calendar.repositories.EventRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class EventRepositoryIntegrationTest {
    private EventRepository eventRepo;

    @Autowired
    public EventRepositoryIntegrationTest(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }


}
