package library;

import users.Member;

import java.util.*;

public class Library {

    private Set<String> authors;
    private Set<String> categories;
    private List<Book> books;
    private Map<Book, Member> borrowedBooks;

    public Library() {
        this.books = new ArrayList<>();
        authors = new HashSet<>();
        categories = new HashSet<>();
        borrowedBooks = new HashMap<>();
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

    public Map<Book, Member> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "Library{" +
                "authors=" + authors +
                ", categories=" + categories +
                ", books=" + books +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
