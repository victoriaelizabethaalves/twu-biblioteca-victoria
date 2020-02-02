package com.twu.biblioteca.service;

import com.twu.biblioteca.Reader;
import com.twu.biblioteca.Writer;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private String menuOptions = "Menu \n 1 - List of all books\n 2 - Quit \n";
    private Reader reader;
    private Writer writer;
    private List<Book> bookList;

    public LibraryService(List<Book> bookList, Reader reader, Writer writer) {
        this.bookList = bookList;
        this.reader = reader;
        this.writer = writer;
    }

    public List<Book> listOfBooks() {
        List<Book> filteredBookList = new ArrayList<>();
        for (Book book: bookList) {
            if(!book.isCheckedOut()){
                filteredBookList.add(book);
            }
        }
        return filteredBookList;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String listOfMenuOptions() {
        return menuOptions;
    }

    private int chooseAMenuOption() {
        int option;

        System.out.printf("\nPlease choose an option: ");
        option = reader.nextInt();

        return option;
    }

    public void menu() {
        int menuOptionChosen = 0;

        while (menuOptionChosen != 2) {
            menuOptionChosen = chooseAMenuOption();

            if (menuOptionChosen == 1) {
                for(Book book:bookList) {
                    writer.out(book.toString());
                }
            } else if (menuOptionChosen == 2) {
                System.out.println("\nPlease select a valid option!");
            }
        }
    }

    public void checkBookOut(Book bookToBeCheckedOut) {
        for (Book book:bookList) {
            if(book.equals(bookToBeCheckedOut)) {
                book.checkOut();
            }
        }
    }
}
