
package service;

import domain.*;
import exceptions.BookNotFoundException;
import exceptions.RecordNotFoundException;

import java.util.List;
import java.util.Optional;

public class CatalogService {
    private BookService bookService;
    private MusicService musicService;
    private AddresService addresService;
    private CDService cdService;
    private GenreService genreService;

    public CatalogService(BookService bookService, MusicService musicService) {
        this.bookService = bookService;
        this.musicService = musicService;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Added Database Functions Here -----------------------------------------------------
    //-----------Books
    public List<Book> getAllBooksFromDB() {

        return bookService.getAllBooksDB();
    }

    public Book addNewBookToDB(Book book) {

        return bookService.addNewBookToDB(book);
    }

    public Optional<Book> findBookByIdDB (Integer id){
        return bookService.getBookByIdDB(id);
    }

    //-----------Address
    public Address addNewAddressToDB(Address address)
    {
        return addresService.addNewAddressToDB(address);
    }

    public List<Address> getAllAddressesFromDB()
    {
        return addresService.getAllAddressesDB();
    }

    //------------Genre
    public Genre addNewGenreToDB (Genre genre)
    {
        return genreService.addNewGenreToDB(genre);
    }

    public List<Genre> getAllGenresFromDB()
    {
        return genreService.getAllGenresDB();
    }

    public Genre addNewGenreToDb(Genre genre)
    {
        return genreService.addNewGenreToDB(genre);
    }

    public void deleteGenreFromDB(Integer id) {
        Optional<Genre> genreTBD = genreService.getGenreByIdDB(id);
        genreTBD.ifPresent(genre -> genreService.removeGenreDB(genre));
    }





    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // Book methods

    // add a book to the catalog
    public void addBook(Book book) {
        bookService.addBook(book);
    }

    // remove book from catalog
    public void removeBook(Book book) {
        bookService.removeBook(book);
    }

    // searches book in catalog
    public List<Book> searchBooks(String query) {
        return bookService.searchBooks(query);
    }

    // return a book by isbn
//    public Book getBookByIsbn(String isbn) throws BookNotFoundException {
//        return bookService.getBookByIsbn(isbn);
//    }

    // returns all books from the catalog
    public List<Book> getAllBooks() {

        return bookService.getAllBooks();
        //return bookService.getAllBooksDB();
    }



    // returns book by id
    public Book getBookById(int id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }



    // Record methods

    // add a record to the catalog
    public void addRecord(Record record) {
        musicService.addRecord(record);
    }

    // remove a record from the catalog
    public void removeRecord(Record record) throws RecordNotFoundException {
        musicService.removeRecord(record.getId());
    }

    // searches record in catalog
    public List<Record> searchRecords(String query) {
        return musicService.searchRecords(query);
    }

    // returns all records from the catalog
    public List<Record> getAllRecords() {
        return musicService.getAllRecords();
    }

    // returns record by id
    public Record getRecordById(int id) throws RecordNotFoundException {
        return musicService.getRecordById(id);
    }

    // CD methods

    // add a CD to the catalog
    public void addCD(CD cd) {
        musicService.addCD(cd);
    }

    // remove a CD from the catalog
    public void removeCD(CD cd) throws RecordNotFoundException {
        musicService.removeCD(cd.getId());
    }

    // searches CD in catalog
    public List<CD> searchCDs(String query) {
        return musicService.searchCDs(query);
    }

    // returns all CDs from the catalog
    public List<CD> getAllCDs() {
        return musicService.getAllCDs();
    }

    // returns CD by id
    public CD getCDById(int id) throws RecordNotFoundException {
        return musicService.getCDById(id);
    }


}

