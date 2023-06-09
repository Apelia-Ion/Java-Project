
package service;

import domain.Book;
import exceptions.BookNotFoundException;
import persistence.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookService {
    private List<Book> books;

    public BookService() {
        this.books = new ArrayList<>();
    }

    private final BookRepository bookRepository = BookRepository.getInstance();



    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Added Database Functions Here ------------------------------------------------------
    //

    public List<Book> getAllBooksDB() {
        return bookRepository.findAll();
    }

    public Book addNewBookToDB(Book book) {


        return bookRepository.save(book);
    }

    public Optional<Book> getBookByIdDB(Integer id)  {
        Optional<Book> book = bookRepository.findById(id);
        return book;
    }

    public void removeBookDB(Book book){
        bookRepository.findById(book.getId());
        bookRepository.delete(book);
    }




    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public Book getBookById(int id) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new BookNotFoundException("Book with ID " + id + " not found.");
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    //searches books by title or author
    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toString().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public void printBook(int id) {
        Book book = null;
        try {
            book = getBookById(id);
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(book.toString());
    }

}


