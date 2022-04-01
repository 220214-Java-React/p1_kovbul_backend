package com.revature.repositories;


import com.revature.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

    public class UserRepositoryTest {

        private UserRepository userRepository;

        @BeforeEach
        public void setup() {
            userRepository = new UserRepository();
        }

        //Testing the user is being put into the database.
        @Test
        public void whenCreateUserIsCalledDoesNotThrowExceptionAndUserIsCreated() {
            User user = new User("Test1", "Password1");
            Assertions.assertDoesNotThrow(() -> userRepository.create(user));
        }
    }
