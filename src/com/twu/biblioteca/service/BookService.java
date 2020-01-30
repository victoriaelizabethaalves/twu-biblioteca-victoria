package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> bookList;

    public List<Book> listOfBooks() {
        bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter", "J.K. Rowling", 1998));
        bookList.add(new Book("The Little Prince", "Anthony", 1970));
        bookList.add(new Book("1984", "George Orwell", 1984));

        return bookList;
    }

    public String listOfMenuOptions(){
        return "Menu of Biblioteca:\n 1 - List of books";
    }
}
