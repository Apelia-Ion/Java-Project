package service;

import domain.*;
import exceptions.BookNotFoundException;

import java.util.*;

public class CatalogService {
    private Catalog catalog;

    public CatalogService() {
        this.catalog = new Catalog();
    }

    public void addBook(Book book) {
        if (this.catalog.getAllBooks().contains(book)) {
            throw new IllegalArgumentException("Book already exists in catalog");
        }
        this.catalog.getAllBooks().add(book);
    }

    public void removeBook(Book book) {
        if (!this.catalog.getAllBooks().remove(book)) {
            throw new BookNotFoundException("Book not found in catalog");
        }
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : this.catalog.getAllBooks()) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toString().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public Book getBookByIsbn(String isbn) {
        for (Book book : this.catalog.getAllBooks()) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found in catalog");
    }

    public List<Book> getAllBooks() {
        return this.catalog.getAllBooks();
    }
}
