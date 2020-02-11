package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void getUserPassword() {
        User user = new User("password123", "111-1234","victoria", "vicky@gmail.com", "99999999");

        assertEquals("password123", user.getPassword());
    }

    @Test
    public void getUserLibraryNumber() {
        User user = new User("password123", "111-1234", "christian", "chris@gmail.com", "88888888");

        assertEquals("111-1234", user.getLibraryNumber());
    }
}
