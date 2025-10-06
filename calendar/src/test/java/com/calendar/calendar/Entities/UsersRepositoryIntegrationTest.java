package com.calendar.calendar.Entities;

import com.calendar.calendar.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
@ExtendWith(SpringExtension.class)
public class UsersRepositoryIntegrationTest {
    private UserRepository userRepo;

    @Autowired
    public UsersRepositoryIntegrationTest(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Test
    public void testUserCreation() {
        Users users = Users.builder()
                .email("email@email.com")
                .name("Test")
                .password("password")
                .build();

        userRepo.save(users);
        assertEquals(1, userRepo.count());
    }

}
