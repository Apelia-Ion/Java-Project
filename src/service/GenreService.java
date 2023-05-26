package service;

import domain.Genre;
import persistence.GenreRepository;
import java.util.List;
import java.util.Optional;


public class GenreService {
    private List<Genre> genres;


    private final GenreRepository genreRepository = GenreRepository.getInstance();

    public GenreService(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> getAllGenresDB() {
        return genreRepository.findAll();
    }

    public Genre addNewGenreToDB(Genre genre) {
        return genreRepository.save(genre);
    }

    public Optional<Genre> getGenreByIdDB(Integer id) {
        return genreRepository.findById(id);
    }

    public void removeGenreDB(Genre genre){
        genreRepository.findById(genre.getId());
        genreRepository.delete(genre);
    }
}
