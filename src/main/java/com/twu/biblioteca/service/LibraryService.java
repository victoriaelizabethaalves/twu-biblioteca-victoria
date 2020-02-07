package com.twu.biblioteca.service;

import com.twu.biblioteca.Reader;
import com.twu.biblioteca.Writer;
import com.twu.biblioteca.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryService {
    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private String menuOptions = "Menu \n 1 - List of all books\n 2 - Quit\n 3 - Checkout a book\n 4 - Return a book";
    private Reader reader;
    private Writer writer;
    private List<Book> bookList;

    public LibraryService(List<Book> bookList, Reader reader, Writer writer) {
        this.bookList = bookList;
        this.reader = reader;
        this.writer = writer;
    }

    public List<Book> listOfBooks() {
        return bookList.stream()
                .filter(book -> !book.isCheckedOut())
                .collect(Collectors.toList());
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String listOfMenuOptions() {
        return menuOptions;
    }

    private int chooseAMenuOption() {
        int option;

        System.out.println("\nPlease choose an option: ");
        option = reader.nextInt();

        return option;
    }

    public void menu() {
        int menuOptionChosen = 0;

        while (menuOptionChosen != 2) {
            menuOptionChosen = chooseAMenuOption();

            if (menuOptionChosen == 1) {
                for (Book book : listOfBooks()) {
                    writer.out(book.toString());
                }
            } else if (menuOptionChosen == 2) {
                System.out.println("\nPlease select a valid option!");
            } else if (menuOptionChosen == 3) {
                int book;
                System.out.println("\nSelect the book you want to check out: ");
                book = reader.nextInt();
                writer.out(checkBookOut(book));
            } else if (menuOptionChosen == 4) {
                int bookId;
                System.out.println("\nSelect the book you want to return: ");
                bookId = reader.nextInt();
                writer.out(returnBook(bookId));
            }
        }
    }

    private Book getBookFromBookId(int bookId, List<Book> list) {
        for (Book book : list) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public String checkBookOut(int bookId) {
        Book book;
        book = getBookFromBookId(bookId, listOfBooks());

        if (book != null) {
            book.checkOut();
            return "Thank you! Enjoy the book!";
        } else {
            return "Sorry, the book is not available.";
        }
    }

    public String returnBook(int bookId) {
        Book book;
        book = getBookFromBookId(bookId, this.bookList);

        if (book != null) {
            book.checkIn();
            return "Thank you for returning the book!";
        } else {
            return "That is not a valid book to return.";
        }
    }
}
