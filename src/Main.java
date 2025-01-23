public class Main {
    public static void main(String[] args) {

        Writer writer1 = new Writer(1,"writer1");
        Category category1 = new Category(1,"category1");


        Book book1 = new Book(1,"book1",writer1,category1,Status.AVAILABLE);
        Book book2 = new Book(2,"book2",writer1,category1,Status.AVAILABLE);

        System.out.println(writer1.getBooks());

    }
}