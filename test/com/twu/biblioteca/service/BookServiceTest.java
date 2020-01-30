package com.twu.biblioteca.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookService();

    @Test
    public void listAllBooksAfterWelcomeMessage(){
        assertNotNull(bookService.listOfBooks());
    }
}

