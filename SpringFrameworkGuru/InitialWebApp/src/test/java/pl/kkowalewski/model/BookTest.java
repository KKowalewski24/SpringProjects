package pl.kkowalewski.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private Book book;
    private Book bookSecond;

    /*------------------------ METHODS REGION ------------------------*/
    @Before
    public void setUp() throws Exception {
        book = new Book();
        bookSecond = new Book();
    }

    @Test
    public void equalsTest() {
        assertTrue(book.equals(bookSecond)
                && bookSecond.equals(book));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(book.hashCode(), bookSecond.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(book.toString());
    }
}