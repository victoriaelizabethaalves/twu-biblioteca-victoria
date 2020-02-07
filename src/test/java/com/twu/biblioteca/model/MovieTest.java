package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void getsMovieName() {
        Movie movie = new Movie("The Lion King", 1990, "Disney", Rating.NINE, 1);

        assertEquals("The Lion King", movie.getName());
    }

    @Test
    public void getsMovieYear() {
        Movie movie = new Movie("The Lion King", 1990, "Disney", Rating.NINE, 1);

        assertEquals(1990, movie.getYear());
    }

    @Test
    public void getsMovieDirector() {
        Movie movie = new Movie("The Lion King", 1990, "Disney", Rating.NINE, 1);

        assertEquals("Disney", movie.getDirector());
    }

    @Test
    public void getsMovieRating() {
        Movie movie = new Movie("The Lion King", 1990, "Disney", Rating.NINE, 1);

        assertEquals(Rating.NINE, movie.getRating());
    }

    @Test
    public void convertsToString() {
        Movie movie = new Movie("The Lion King", 1990, "Disney", Rating.NINE, 1);

        assertEquals("Id: 1 | Name: The Lion King | Year: 1990 | Director: Disney | Rating: 9", movie.toString());
    }

//    @Test
//    public void setsMovieRating() {
//        Movie movie = new Movie("The Lion King", 1990, "Disney", Rating.NINE);
//
//        movie.setRating(rating.ONE);
//
//        assertEquals(Rating.NINE, movie.getRating());
//    }
}
