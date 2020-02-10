package com.twu.biblioteca.model;

public class User {
    private String password;
    private String libraryNumber;

    public User(String password, String libraryNumber) {
        this.password = password;
        this.libraryNumber = libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }
}
