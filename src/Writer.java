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

    public int getWriterId() {
        return writerId;
    }

    public String getWriterName() {
        return writerName;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "writerId=" + writerId +
                ", writerName='" + writerName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return writerId == writer.writerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(writerId);
    }

}
