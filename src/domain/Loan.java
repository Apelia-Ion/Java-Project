package domain;

import java.security.KeyStore;
import java.time.LocalDate;



public class Loan {
    private Integer id;
    private Borrower borrower;
    private Book book;
    private LocalDate dueDate;
    private Boolean returned;

    public Loan(Integer id, Borrower borrower, Book book, LocalDate dueDate, Boolean returned) {
        this.id =id;
        this.borrower = borrower;
        this.book = book;
        this.dueDate = dueDate;
        this.returned=true;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    public int daysOverdue() {
        if (isOverdue()) {
            return (int) ((long) LocalDate.now().toEpochDay() - dueDate.toEpochDay());
        } else {
            return 0;
        }
    }

    public double calculateFine(double fineRate) {
        if (isOverdue()) {
            int daysOverdue = daysOverdue();
            return fineRate * daysOverdue;
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return String.format("%s checked out %s, due on %s (%s)", borrower.getName(), book.getTitle(), dueDate.toString(),
                isOverdue() ? "overdue" : "not overdue");
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
