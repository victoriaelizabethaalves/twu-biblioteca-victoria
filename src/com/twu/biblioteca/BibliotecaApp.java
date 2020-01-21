package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.service.BookService;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookService bookService = new BookService();

        System.out.println(bookService.getWelcomeMessage());
        System.out.println(bookService.listOfBooks());
    }
}