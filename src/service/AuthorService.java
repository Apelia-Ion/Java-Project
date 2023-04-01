package service;

import domain.*;
import exceptions.AuthorNotFoundException;

import java.util.*;

public class AuthorService {
    private List<Author> authors;

    public AuthorService() {
        this.authors = new ArrayList<>();
    }

    public List<Author> getAllAuthors() {
        return this.authors;
    }

    public void addAuthor(Author author) {
        if (this.authors.contains(author)) {
            throw new IllegalArgumentException("Author already exists");
        }
        this.authors.add(author);
    }

    public void removeAuthor(Author author) {
        if (!this.authors.remove(author)) {
            throw new AuthorNotFoundException("Author not found");
        }
    }

    public List<Author> searchAuthors(String query) {
        List<Author> results = new ArrayList<>();
        for (Author author : this.authors) {
            if (author.getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(author);
            }
        }
        return results;
    }

    public Author getAuthorByName(String name) {
        for (Author author : this.authors) {
            if (author.getName().equalsIgnoreCase(name)) {
                return author;
            }
        }
        throw new AuthorNotFoundException("Author not found");
    }

    public void toLowerCase() {
        for (Author author : this.authors) {
            author.setName(author.getName().toLowerCase());
        }
    }
}
