package com.twu.biblioteca.service;

import com.twu.biblioteca.Reader;
import com.twu.biblioteca.Writer;
import com.twu.biblioteca.model.User;

import java.util.List;

public class UserService {
    private final List<User> userList;
    private final Reader reader;
    private final Writer writer;

    public UserService(List<User> userList, Reader reader, Writer writer) {
        this.userList = userList;
        this.reader = reader;
        this.writer = writer;
    }

    public User login() {
        User user = null;
        String password = null;
        String name = null;
        String email = null;
        String phoneNumber = null;

        do {
            writer.out("\nEnter with your library number: ");
            String libraryNumber = reader.nextLine();

            writer.out("\nEnter with your password: ");
            password = reader.nextLine();

            writer.out("\nEnter with your name: ");
            name = reader.nextLine();

            writer.out("\nEnter with your email: ");
            email = reader.nextLine();

            writer.out("\nEnter with your phone number: ");
            phoneNumber = reader.nextLine();

           user = getUserFromLibraryNumber(libraryNumber);
        } while(user == null && !password.equals(user.getPassword()));

        return user;
    }

    public void info() {
        User user = null;

        writer.out("\nEnter with your library number: ");
        String libraryNumberWanted = reader.nextLine();

        user = getUserFromLibraryNumber(libraryNumberWanted);
        if(user != null )
            writer.out(String.format("Name: %s | Email: %s | Phone Number: %s", user.getName(), user.getEmail(), user.getPhoneNumber()));
        else writer.out("User does not exist!");
    }

    private User getUserFromLibraryNumber(String libraryNumber) {
        for (User user : userList) {
            if (user.getLibraryNumber().equals(libraryNumber)) {
                return user;
            }
        }
        return null;
    }
}
