package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void displaysWelcomeMessageWhenStartingApplication() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
                bibliotecaApp.mainService(new String[100]));
    }
}
