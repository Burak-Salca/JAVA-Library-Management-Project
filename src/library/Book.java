package library;

public class Book {

    private int bookId;
    private String bookName;
    private double price;
    private String author;  //
    private String category;
    private boolean status= true;

    public Book(int bookId,String bookName, double price, String author, String category) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.category = category;
    }

    //Update fonksiyonu için böyle bi constructor tanımladık
    public Book(String bookName, double price, String author, String category) {
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
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
                ", price=" + price +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", status=" + status +
                '}';
    }
}
