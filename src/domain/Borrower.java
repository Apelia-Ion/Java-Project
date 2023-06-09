package domain;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private Integer id;
    private String name;
    private Address address;
    private String contactInfo;
    private List<Loan> loans;

    public Borrower(Integer id,String name, Address address, String contactInfo) {
        this.id =id;
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.loans = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
