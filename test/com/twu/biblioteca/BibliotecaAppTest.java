package com.twu.biblioteca;

import com.twu.biblioteca.service.LibraryService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void displaysWelcomeMessageWhenStartingApplication() {
        LibraryService libraryService = new LibraryService(null);

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
                libraryService.getWelcomeMessage());
    }
}
