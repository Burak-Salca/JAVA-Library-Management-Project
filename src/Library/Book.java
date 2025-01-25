package Library;

import java.util.HashSet;
import java.util.Set;

public class Book {

    private int bookId;
    private String bookName;
    private String author;  //
    private String category;
    private Status status;

    public Book(int bookId,String bookName, String author, String category, Status status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", writer=" + author +
                ", category=" + category +
                ", status=" + status +
                '}';
    }


}
