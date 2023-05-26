package service;
import domain.Book;
import domain.CD;
import persistence.CDRepository;
import java.util.List;



public class CDService {
    private List<CD> CDs;


    private final CDRepository cDRepository = CDRepository.getInstance();

    public CDService(List<CD> CDs) {
        this.CDs = CDs;
    }

    public List<CD> getAllCDsDB() {
        return cDRepository.findAll();
    }
}
