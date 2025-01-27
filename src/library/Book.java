package library;

public class Book {

    private int bookId;
    private String bookName;
    private String author;  //
    private String category;
    private boolean status= true;

    public Book(int bookId,String bookName, String author, String category) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;

    }

    //Update fonksiyonu için böyle bi constructor tanımladık
    public Book(String bookName, String author, String category) {
        this.bookName = bookName;
        this.author = author;
        this.category = category;
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

    public boolean getStatus() {
        return status;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author=" + author +
                ", category=" + category +
                ", status=" + status +
                '}';
    }

}
