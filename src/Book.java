import java.util.Objects;

public class Book {

    private int bookId;
    private String bookName;
    private Writer writer;
    private Category catetory;
    private Status status;

    public Book(int bookId, String bookName, Writer writer, Category catetory, Status status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.writer = writer;
        this.catetory = catetory;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Category getCatetory() {
        return catetory;
    }

    public void setCatetory(Category catetory) {
        this.catetory = catetory;
    }

    public Status getStatus() {
        return status;
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
                ", catetory=" + catetory +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && Objects.equals(bookName, book.bookName) && Objects.equals(writer, book.writer) && Objects.equals(catetory, book.catetory) && status == book.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, writer, catetory, status);
    }
}
