package Library;

import java.util.HashSet;
import java.util.Set;

public class Book {

    private int bookId;
    private String bookName;
    private Writer writer;
    private Category category;
    private Status status;
    private static final Set<Integer> usedIds = new HashSet<>();

    public Book(int bookId, String bookName, Writer writer, Category category, Status status) {
        if (!usedIds.add(bookId)) {
            throw new IllegalArgumentException("Bu ID'ye sahip bir kitap zaten mevcut: " + bookId);
        }
        this.bookId = bookId;
        this.bookName = bookName;
        this.writer = writer;
        this.category = category;
        this.status = status;

        writer.addBook(this);
        category.addBook(this);
    }

    public Book(String bookName, Writer writer, Category category, Status status) {
        this.bookName = bookName;
        this.writer = writer;
        this.category = category;
        this.status = status;

        writer.addBook(this);
        category.addBook(this);
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public Writer getWriter() {
        return writer;
    }

    public Category getCategory() {
        return category;
    }

    public Status getStatus() {
        return status;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", writer=" + writer +
                ", category=" + category +
                ", status=" + status +
                '}';
    }
}
