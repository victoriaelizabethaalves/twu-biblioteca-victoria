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
        do {
            writer.out("\nEnter with your library number: ");
            String libraryNumber = reader.nextLine();

            writer.out("\nEnter with your password: ");
            password = reader.nextLine();

           user = getUserFromLibraryNumber(libraryNumber);
        } while(user == null && !password.equals(user.getPassword()));

        return user;
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
