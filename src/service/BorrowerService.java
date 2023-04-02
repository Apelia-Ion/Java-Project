package service;

import domain.*;
import exceptions.BorrowerNotFoundException;

import java.util.*;

public class BorrowerService {
    private List<Borrower> borrowers;

    public BorrowerService() {
        this.borrowers = new ArrayList<>();
    }

    public void addBorrower(String name, Address address, String contactInfo) {
        Borrower borrower = new Borrower(name, address, contactInfo);
        borrowers.add(borrower);
    }

    public Borrower findBorrower(String name) throws BorrowerNotFoundException {
        for (Borrower borrower : borrowers) {
            if (borrower.getName().equals(name)) {
                return borrower;
            }
        }
        throw new BorrowerNotFoundException("Borrower not found: " + name);
    }
}

