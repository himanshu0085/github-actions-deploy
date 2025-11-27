package com.example.bankapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankappApplicationTests {

    @Test
    void contextLoads() {
        // Ensures Spring Boot application starts successfully
    }

    @Test
    void sampleTest() {
        int expected = 42;
        int actual = 40 + 2;
        assertEquals(expected, actual, "Simple addition should equal 42");
    }

    @Test
    void anotherSampleTest() {
        String message = "Hello, BankApp!";
        assertNotNull(message, "Message should not be null");
        assertTrue(message.contains("BankApp"), "Message should contain 'BankApp'");
    }
}
