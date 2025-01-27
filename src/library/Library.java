package library;

import java.util.*;

public class Library {

    private Set<String> authors;
    private Set<String> categories;
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
        authors = new HashSet<>();
        categories = new HashSet<>();
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public List<Book> getBooks() {
        return books;
    }
}
