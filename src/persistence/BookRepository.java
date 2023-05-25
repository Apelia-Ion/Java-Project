package persistence;
import domain.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static persistence.util.DbConnection.getDatabaseConnection;

public class BookRepository implements GenericRepository<Book> {

    private final Map<String, Book> storage = new HashMap<>();
    private static final String INSERT_BOOK_SQL = "INSERT INTO book (id, title, author, isbn, publicationDate, genre) VALUES (?, ?, ?, ?, ?, ?)";


    private final Connection connection;

    private static volatile BookRepository instance;

    private BookRepository() {
        this.connection = getDatabaseConnection();
    }

    public static BookRepository getInstance() {
        if (instance == null) {
            synchronized (BookRepository.class) {
                if (instance == null) {
                    instance = new BookRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public Book save(Book entity) {
        storage.put(String.valueOf(entity.getId()), entity);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getTitle());
            preparedStatement.setString(3, entity.getAuthor().getName());
            preparedStatement.setString(4, entity.getIsbn());
            preparedStatement.setString(5, entity.getPublicationDate());
            preparedStatement.setString(6, entity.getGenre().getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());

    }




}
