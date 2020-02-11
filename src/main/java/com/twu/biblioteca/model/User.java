package com.twu.biblioteca.model;

public class User {
    private String password;
    private String libraryNumber;
    private String name;
    private String email;
    private String phoneNumber;

    public User(String password, String libraryNumber, String name, String email, String phoneNumber) {
        this.password = password;
        this.libraryNumber = libraryNumber;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
