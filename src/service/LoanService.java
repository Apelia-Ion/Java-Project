package service;

import domain.Loan;
//import domain.*;
import java.time.LocalDate;

public class LoanService {
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
}
