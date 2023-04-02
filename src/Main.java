import domain.*;
import exceptions.BookNotFoundException;
import exceptions.BorrowerNotFoundException;
import service.*;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        //initializez serviciile si catalogul bibliotecii

        BorrowerService borrowerService =new BorrowerService();
        LoanService loanService = new LoanService();
        BookService bookService = new BookService();
        MusicService musicService =new MusicService();
        CatalogService catalogService = new CatalogService(bookService, musicService);

        // Acum adaug niste date pt a putea realiza actiuni
        Genre technicalGenre = new Genre("Technical", "Books that teach technical skills");
        Genre fiction = new Genre("Fiction", "Fiction is the art of creating stories that are not entirely true, but may still be based on real events or real people.");

        Author author1 = new Author("John Doe", "14/07/1977", "Romanian", new Address("123 Main St", "Anytown", "y78y"));
        Author author2 = new Author("Jane Austen", "02/04/1980", "English", new Address("456 Oak Ave", "Othertown", "9898"));

        Book book1 = new Book(1,"Java 101", author1, "1234567890", "01/01/2022", technicalGenre);
        Book book2 = new Book(2,"Python for Beginners", author2, "0987654321", "01/01/2022", technicalGenre);
        Book book3 = new Book(3,"The Catcher in the Rye", new Author("J.D. Salinger", null, "Finnish", null), "5555555555", "01/01/1951", fiction);


        catalogService.addBook(book1);
        catalogService.addBook(book2);
        catalogService.addBook(book3);


        // Create some records
        Record darkSideOfTheMoon = new Record(1, "The Dark Side of the Moon", author1, 1973, "Harvest Records");
        Record housesOfTheHoly = new Record(2, "Houses of the Holy", author1, 1973, "Atlantic Records");
        Record abbeyRoad = new Record(3, "Abbey Road", author1, 1969, "Apple Records");
        Record letItBleed = new Record(4, "Let It Bleed", author1, 1969, "Decca Records");

        // Create some CDs
        CD theWallCD = new CD(1, "The Wall", author1, 1979, "Harvest Records");
        CD physicalGraffiti = new CD(2, "Physical Graffiti", author1, 1975, "Swan Song Records");
        CD revolver = new CD(3, "Revolver", author1, 1966, "Parlophone Records");
        CD stickyFingers = new CD(4, "Sticky Fingers", author1, 1971, "Rolling Stones Records");

        // Add records and CDs to the catalog
        catalogService.addRecord(darkSideOfTheMoon);
        catalogService.addRecord(housesOfTheHoly);
        catalogService.addRecord(abbeyRoad);
        catalogService.addRecord(letItBleed);
        catalogService.addCD(theWallCD);
        catalogService.addCD(physicalGraffiti);
        catalogService.addCD(revolver);
        catalogService.addCD(stickyFingers);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("0. Exit App");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search book by ID");
            System.out.println("4. Search book by title");
            System.out.println("5. Display all books");
            System.out.println("6. Search Record");
            System.out.println("7. Search CD");
            System.out.println("8. Issue Loan");
            System.out.println("9. Add Borrower");
            System.out.println("10. Return Loan");

            System.out.print("Enter option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Enter (int) bookid: ");
                    scanner.nextLine(); // Consume newline
                    Integer bookId = scanner.nextInt();

                    System.out.print("Enter title: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();

                    System.out.print("Enter author name: ");
                    String authorName = scanner.nextLine();

                    System.out.print("Enter author Date of birth: ");
                    String authorDateOfBirth = scanner.nextLine();

                    System.out.print("Enter author nationality: ");
                    String authorNationality = scanner.nextLine();

                    System.out.print("Enter author Street: ");
                    String authorStreet = scanner.nextLine();

                    System.out.print("Enter author City: ");
                    String authorCity = scanner.nextLine();

                    System.out.print("Enter author ZipCode: ");
                    String authorZip = scanner.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Enter publication date (MM/DD/YYYY): ");
                    String publicationDate = scanner.nextLine();

                    System.out.print("Enter genre name: ");
                    String genreName = scanner.nextLine();

                    System.out.print("Enter genre description: ");
                    String genreDescription = scanner.nextLine();

                    Address authorAddress = new Address(authorStreet, authorCity, authorZip);
                    Author author = new Author(authorName, authorDateOfBirth, authorNationality, authorAddress);
                    Genre genre = new Genre(genreName, genreDescription);
                    Book book = new Book(bookId, title, author, isbn, publicationDate, genre);
                    catalogService.addBook(book);
                    System.out.println("Book added successfully to catalog.");
                    break;
                case 2:
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextInt();
                    try {
                        book = catalogService.getBookById(bookId);
                        catalogService.removeBook(book);
                    } catch (BookNotFoundException e) {
                        System.out.println(e);
                    }

                    break;
                case 3:
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextInt();
                    bookService.printBook(bookId);
                    break;
                case 4:
                    System.out.print("Enter book Title: ");
                    String querry = scanner.next();
                    List<Book> result = catalogService.searchBooks(querry);
                    System.out.println(result);
                    break;
                case 5:
                    result = catalogService.getAllBooks();
                    System.out.println(result);
                    break;
                case 6:
                    System.out.print("Enter CD id: ");
                    Integer cdId = scanner.nextInt();
                    musicService.printCD(cdId);
                    break;
                case 7:
                    System.out.print("Enter Record id: ");
                    Integer recordId = scanner.nextInt();
                    musicService.printRecord(recordId);
                    break;
                case 8:
                    System.out.println("Enter Borrower Name: ");
                    Borrower borrower = null;
                    String bName = scanner.next();
                    try {
                         borrower = borrowerService.findBorrower(bName);
                    } catch (BorrowerNotFoundException e) {
                        System.out.println(e);
                        System.out.println("Please make a new borrower account");
                        break;
                    }
                    System.out.println("Borrower " + bName + " found.");
                    if (borrower.getLoans().size() < 3)
                    System.out.println("Enter (int) book id: ");
                    bookId = scanner.nextInt();
                    book = null;
                    try {
                        book = bookService.getBookById(bookId);
                    } catch (BookNotFoundException e) {
                        System.out.println(e);
                        System.out.println("retry process");
                        break;
                    }
                    System.out.println("Enter due date: (MM/DD/YYYY) ");
                    String inputDate = scanner.nextLine();

                    LocalDate duedate = LocalDate.parse(inputDate);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    String formattedDate = duedate.format(formatter);

                    loanService.makeLoan(borrower,book,duedate);
                case 9:
                    System.out.println("Enter the new borrower's name:");
                    bName = scanner.next();

                    System.out.print("Enter borrower Street: ");
                    String bStreet = scanner.nextLine();

                    System.out.print("Enter borrower City: ");
                    String brCity = scanner.nextLine();

                    System.out.print("Enter borrower ZipCode: ");
                    String bZip = scanner.nextLine();

                    System.out.print("Enter borrower contact info: ");
                    String bContact = scanner.nextLine();

                    Address bAddress = new Address(bStreet, brCity, bZip);

                    borrowerService.addBorrower(bName,bAddress,bContact);

            }

        }



    }
}
