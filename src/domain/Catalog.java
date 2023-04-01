package domain;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Book> books;

    public Catalog() {
        this.books = new ArrayList<>();
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
