package pl.kkowalewski.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AuthorTest {

    /*------------------------ FIELDS REGION ------------------------*/
    private Author author;
    private Author authorSecond;

    /*------------------------ METHODS REGION ------------------------*/
    @Before
    public void setUp() throws Exception {
        author = new Author();
        authorSecond = new Author();
    }

    @Test
    public void equalsTest() {
        assertTrue(author.equals(authorSecond)
                && authorSecond.equals(author));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(author.hashCode(), authorSecond.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(author.toString());
    }
}