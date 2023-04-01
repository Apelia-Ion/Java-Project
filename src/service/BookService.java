package service;

import domain.Book;
import exceptions.BookNotFoundException;

import java.util.List;

public class BookService {
    private CatalogService catalogService;

    public BookService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    public List<Book> getAllBooks() {
        return catalogService.getAllBooks();
    }

    public Book getBookById(int id) throws BookNotFoundException {
        Book book = catalogService.getBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
        return book;
    }

    public void addBook(Book book) {
        catalogService.addBook(book);
    }

    public void removeBook(Book book) {
        catalogService.removeBook(book);
    }

    public List<Book> searchBooks(String query) {
        return catalogService.searchBooks(query);
    }
}
