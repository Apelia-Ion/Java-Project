package domain;

import java.time.LocalDate;

public class Loan {
    private Borrower borrower;
    private Book book;
    private LocalDate dueDate;

    public Loan(Borrower borrower, Book book, LocalDate dueDate) {
        this.borrower = borrower;
        this.book = book;
        this.dueDate = dueDate;
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
}
