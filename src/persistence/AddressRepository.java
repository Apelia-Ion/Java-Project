package persistence;

import domain.Address;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static persistence.util.DbConnection.getDatabaseConnection;

public class AddressRepository implements GenericRepository<Address>{

    private final Map<Integer, Address> storage = new HashMap<>();
    private static final String INSERT_ADDRESS_SQL = "INSERT INTO address (id, street, city, zipcode) VALUES (?, ?, ?,?)";


    private final Connection connection;

    private static volatile AddressRepository instance;

    private AddressRepository() {
        this.connection = getDatabaseConnection();
    }

    public static AddressRepository getInstance() {
        if (instance == null) {
            synchronized (AddressRepository.class) {
                if (instance == null) {
                    instance = new AddressRepository();
                }
            }
        }
        return instance;
    }


    @Override
    public Address save(Address entity) {
        storage.put(entity.getId(), entity);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADDRESS_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getStreet());
            preparedStatement.setString(3, entity.getCity());
            preparedStatement.setString(4, entity.getZipCode());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public List<Address> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void delete(Address entity) {

    }
}
