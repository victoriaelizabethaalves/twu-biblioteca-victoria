package com.twu.biblioteca.service;

import com.twu.biblioteca.Reader;
import com.twu.biblioteca.Writer;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryService {
    private final UserService userService;
    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private String menuOptions =
            "Menu \n 1 - List of all books\n 2 - Checkout a book\n 3 - Return a book\n 4 - List of all movies\n 5 - Check out a movie\n 6 - Quit\n 7 - User information";
    private Reader reader;
    private Writer writer;
    private List<Book> bookList;
    private List<Movie> movieList;

    public static final int LIST_OF_BOOKS = 1;
    public static final int CHECK_OUT_BOOK = 2;
    public static final int CHECK_IN_BOOK = 3;
    public static final int LIST_OF_MOVIES = 4;
    public static final int CHECK_OUT_MOVIE = 5;
    public static final int QUIT_APPLICATION = 6;
    public static final int USER_INFO = 7;

    public LibraryService(List<Book> bookList, List<Movie> movieList, Reader reader, Writer writer, UserService userService) {
        this.bookList = bookList;
        this.reader = reader;
        this.writer = writer;
        this.movieList = movieList;
        this.userService = userService;
    }

    public List<Book> listOfBooks() {
        return bookList.stream()
                .filter(book -> !book.isCheckedOut())
                .collect(Collectors.toList());
    }

    public List<Movie> listOfMovies() {
        return movieList.stream()
                .filter(movie -> !movie.isCheckedOut())
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

        while (menuOptionChosen != QUIT_APPLICATION) {
            menuOptionChosen = chooseAMenuOption();

            if (menuOptionChosen == LIST_OF_BOOKS) {
                for (Book book : listOfBooks()) {
                    writer.out(book.toString());
                }
            } else if (menuOptionChosen == QUIT_APPLICATION) {
                writer.out("\nPlease select a valid option!");
            } else if (menuOptionChosen == CHECK_OUT_BOOK) {
                int book;
                userService.login();
                writer.out("\nSelect the book you want to check out: ");
                book = reader.nextInt();
                writer.out(checkBookOut(book));
            } else if (menuOptionChosen == CHECK_IN_BOOK) {
                int bookId;
                writer.out("\nSelect the book you want to return: ");
                bookId = reader.nextInt();
                writer.out(returnBook(bookId));
            } else if (menuOptionChosen == LIST_OF_MOVIES) {
                List<Movie> listOfMovies = listOfMovies();
                for(Movie movie:listOfMovies) {
                    writer.out(movie.toString());
                }
            } else if (menuOptionChosen == CHECK_OUT_MOVIE) {
                int movie;
                writer.out("\nSelect the movie you want to check out: ");
                movie = reader.nextInt();
                writer.out(checkMovieOut(movie));
            } else if (menuOptionChosen == USER_INFO) {
                userService.info();
            }
        }
    }

    private String checkMovieOut(int movieId) {
        Movie movie;
        movie = getMovieFromMovieId(movieId, listOfMovies());

        if (movie != null) {
            movie.checkOut();
            return "Thank you! Enjoy the movie!";
        } else {
            return "Sorry, the movie is not available.";
        }
    }

    private Movie getMovieFromMovieId(int movieId, List<Movie> list) {
        for (Movie movie : list) {
            if (movie.getMovieId() == movieId) {
                return movie;
            }
        }
        return null;
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
