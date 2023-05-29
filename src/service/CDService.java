package service;
import domain.Book;
import domain.CD;
import persistence.CDRepository;

import java.util.ArrayList;
import java.util.List;



public class CDService {
    private List<CD> CDs;


    private final CDRepository cDRepository = CDRepository.getInstance();

    public CDService() {
        this.CDs = new ArrayList<>();
    }

    public List<CD> getAllCDsDB() {
        return cDRepository.findAll();
    }
}
