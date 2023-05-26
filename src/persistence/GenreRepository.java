package persistence;

import domain.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static persistence.util.DbConnection.getDatabaseConnection;

public class GenreRepository implements GenericRepository<Genre>{

    private final Map<Integer, Genre> storage = new HashMap<>();
    private static final String INSERT_GENRE_SQL = "INSERT INTO genre (id, name, description) VALUES (?, ?, ?)";


    private final Connection connection;

    private static volatile GenreRepository instance;

    private GenreRepository() {
        this.connection = getDatabaseConnection();
    }

    public static GenreRepository getInstance() {
        if (instance == null) {
            synchronized (GenreRepository.class) {
                if (instance == null) {
                    instance = new GenreRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public Genre save(Genre entity) {
        storage.put(entity.getId(), entity);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GENRE_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public List<Genre> findAll() {
        return new ArrayList<>(storage.values());

    }

    @Override
    public Optional<Genre> findById(Integer id) {
        Genre genre = storage.get(id);
        return Optional.ofNullable(genre);
    }

    @Override
    public void delete(Genre entity) {
        storage.remove(entity.getId());
    }



}
