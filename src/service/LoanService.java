package service;

import domain.Book;
import domain.Borrower;
import domain.Loan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanService {
    private List<Loan> loans;

    public LoanService() {
        loans = new ArrayList<>();
    }

    public boolean isOverdue(Loan loan) {
        return LocalDate.now().isAfter(loan.getDueDate());
    }

    public int daysOverdue(Loan loan) {
        if (isOverdue(loan)) {
            return (int) ((int) LocalDate.now().toEpochDay() - loan.getDueDate().toEpochDay());
        } else {
            return 0;
        }
    }

    public double calculateFine(Loan loan, double fineRate) {
        if (isOverdue(loan)) {
            int daysOverdue = daysOverdue(loan);
            return fineRate * daysOverdue;
        } else {
            return 0.0;
        }
    }

    public String getLoanDetails(Loan loan) {
        return String.format("%s checked out %s, due on %s (%s)", loan.getBorrower().getName(), loan.getBook().getTitle(),
                loan.getDueDate().toString(), isOverdue(loan) ? "overdue" : "not overdue");
    }

    public Loan makeLoan(Borrower borrower, Book book, LocalDate dueDate) {

        Loan loan = new Loan(borrower, book, dueDate, false);
        if(book.getAvailable() == Boolean.TRUE)
        {
            loans.add(loan);
        }
        else
        {
            System.out.println("Book not available!");
        }

        return loan;
    }

    public List<Loan> getAllLoans() {
        return loans;
    }

    public List<Loan> getOverdueLoans() {
        List<Loan> overdueLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (isOverdue(loan)) {
                overdueLoans.add(loan);
            }
        }
        return overdueLoans;
    }


}
