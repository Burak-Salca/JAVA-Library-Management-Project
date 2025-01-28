package library;

import users.Member;

import java.util.*;

public class Library {

    private Set<String> authors;
    private Set<String> categories;
    private List<Book> books;
    private Map<Book, Member> borrowedBooks;
    private List<Receipt> receipts;

    public Library() {
        this.books = new ArrayList<>();
        authors = new HashSet<>();
        categories = new HashSet<>();
        borrowedBooks = new HashMap<>();
        receipts = new ArrayList<>();
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

    public List<Receipt> getReceipts() {
        return receipts;
    }

    @Override
    public String toString() {
        return "Library{" +
                "authors=" + authors +
                ", categories=" + categories +
                ", books=" + books +
                ", borrowedBooks=" + borrowedBooks +
                ", receipts=" + receipts +
                '}';
    }
}
