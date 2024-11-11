package se.yrgo.libraryapp.validators;

import  org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsernameTest {
    @ParameterizedTest
    @ValueSource(strings = {"user", "User", "user.", "us_er", "user-@"})
    void correctUsername(String username) {
        assertTrue(Username.validate(username), "Expected valid username: " + username);
    }

    @ParameterizedTest
    @ValueSource(strings = {"usr", "user name", "user!", "user%", "****", "u123"})
    @EmptySource
    void incorrectUsername(String username) {
        assertFalse(Username.validate(username), "Expected invalid username: " + username);
    }
}
