package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class MovieTest {

    @Test
    public void getsMovieName() {
        Movie movie = new Movie("The Lion King", 1990, "Disney", Rating.NINE);

        assertEquals("The Lion King", movie.getName());
    }

    @Test
    public void getsMovieYear() {
        Movie movie = new Movie("The Lion King", 1990, "Disney", Rating.NINE);

        assertEquals(1990, movie.getYear());
    }

    @Test
    public void getsMovieDirector() {
        Movie movie = new Movie("The Lion King", 1990, "Disney", Rating.NINE);

        assertEquals("Disney", movie.getDirector());
    }

    @Test
    public void getsMovieRating() {
        Movie movie = new Movie("The Lion King", 1990, "Disney", Rating.NINE);

        assertEquals(Rating.NINE, movie.getRating());
    }

    @Test
    public void convertsToString() {
        Movie movie = new Movie("The Lion King", 1990, "Disney", Rating.NINE);

        assertEquals("Name: The Lion King | Year: 1990 | Director: Disney | Rating: 9", movie.toString());
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
