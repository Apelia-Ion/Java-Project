package persistence;

import domain.CD;


import java.sql.Connection;
import java.util.*;

import static persistence.util.DbConnection.getDatabaseConnection;

public class CDRepository implements GenericRepository<CD> {
    private final Map<Integer, CD> storage = new HashMap<>();


    private final Connection connection;

    private static volatile CDRepository instance;

    private CDRepository() {
        this.connection = getDatabaseConnection();
    }

    public static CDRepository getInstance() {
        if (instance == null) {
            synchronized (CDRepository.class) {
                if (instance == null) {
                    instance = new CDRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public CD save(CD entity) {
        return null;
    }

    @Override
    public List<CD> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<CD> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void delete(CD entity) {

    }
}
