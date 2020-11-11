package pl.kkowalewski.cachedata.model;

public class Book {

    /*------------------------ FIELDS REGION ------------------------*/
    private String isbn;
    private String title;

    /*------------------------ METHODS REGION ------------------------*/
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
