import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member extends People{

    private List<Book> books;

    public Member(int id, String name, List<Book> books) {
        super(id, name);
        this.books = new ArrayList<>();
    }

    public List<Book> returnBook() {
        return null;
    }

    public List<Book> barrowBook() {
        return null;
    }

    public List<Book> getBooks() {
        return books;
    }


    @Override
    public String toString() {
        return "Member{" +
                "books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Member member = (Member) o;
        return Objects.equals(books, member.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), books);
    }
}
