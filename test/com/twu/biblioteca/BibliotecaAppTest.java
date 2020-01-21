package com.twu.biblioteca;


import com.twu.biblioteca.service.BookService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void displaysWelcomeMessageWhenStartingApplication() {
        BookService bookService = new BookService();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
                bookService.getWelcomeMessage());
    }
}
