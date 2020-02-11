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

    @Test
    public void getUserName() {
        User user = new User("password123", "111-1234", "christian", "chris@gmail.com", "88888888");

        assertEquals("christian", user.getName());
    }

    @Test
    public void getUserEmail() {
        User user = new User("password123", "111-1234", "christian", "chris@gmail.com", "88888888");

        assertEquals("chris@gmail.com", user.getEmail());
    }

    @Test
    public void getUserPhoneNumber() {
        User user = new User("password123", "111-1234", "christian", "chris@gmail.com", "88888888");

        assertEquals("88888888", user.getPhoneNumber());
    }
}
