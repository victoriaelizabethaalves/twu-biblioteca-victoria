package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> bookList;

    public List<Book> listOfBooks() {
        bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter"));
        bookList.add(new Book("The Little Prince"));

        return bookList;
    }

    public String getWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        return welcomeMessage;
    }
}