package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Writer {

    private int writerId;
    private String writerName;
    private List<Book> books;

    public Writer(int writerId, String writerName) {
        this.writerId = writerId;
        this.writerName = writerName;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int getWriterId() {
        return writerId;
    }

    public String getWriterName() {
        return writerName;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "writerId=" + writerId +
                ", writerName='" + writerName + '\'' +
                ", books=" + books +
                '}';
    }
}
