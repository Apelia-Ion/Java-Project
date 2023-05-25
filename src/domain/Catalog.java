package domain;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private Integer id;
    private List<Book> books;

//    public Catalog() {
//        this.books = new ArrayList<>();
//    }

    public Catalog(Integer id, List<Book> books) {
        this.id = id;
        this.books = new ArrayList<>();;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
