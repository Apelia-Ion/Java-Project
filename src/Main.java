import domain.*;
import exceptions.BookNotFoundException;
import service.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CatalogService catalogService = new CatalogService();

        Genre technicalGenre = new Genre("Technical", "Books that teach technical skills");
        Genre fiction = new Genre("Fiction", "Fiction is the art of creating stories that are not entirely true, but may still be based on real events or real people.");



        Author author1 = new Author("John", "Doe", "johndoe@example.com", new Address("123 Main St", "Anytown", "USA"));
        Author author2 = new Author("Jane", "Smith", "janesmith@example.com", new Address("456 Oak Ave", "Othertown", "USA"));

        Book book1 = new Book(1,"Java 101", author1, "1234567890", "01/01/2022", technicalGenre);
        Book book2 = new Book(2,"Python for Beginners", author2, "0987654321", "01/01/2022", technicalGenre);
        Book book3 = new Book(3,"The Catcher in the Rye", new Author("J.D.", "Salinger", "", null), "5555555555", "01/01/1951", fiction);

        catalogService.addBook(book1);
        catalogService.addBook(book2);
        catalogService.addBook(book3);

        BookService bookService = new BookService(catalogService);

        // get all books
        System.out.println("All books:");
        List<Book> books = bookService.getAllBooks();
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor().toString());
        }

        // search for books
        System.out.println("\nSearching for 'java':");
        List<Book> searchResults = bookService.searchBooks("java");
        for (Book book : searchResults) {
            System.out.println(book.getTitle() + " by " + book.getAuthor().toString());
        }

        // get book by ID
        int bookId = 2;
        System.out.println("\nGetting book with ID " + bookId + ":");
        try {
            Book bookById = bookService.getBookById(bookId);
            System.out.println(bookById.getTitle() + " by " + bookById.getAuthor().toString());
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // remove book
        System.out.println("\nRemoving book: " + book1.getTitle());
        bookService.removeBook(book1);

        // get all books again
        System.out.println("\nAll books after removal:");
        List<Book> updatedBooks = bookService.getAllBooks();
        for (Book book : updatedBooks) {
            System.out.println(book.getTitle() + " by " + book.getAuthor().toString());
        }
    }
}
