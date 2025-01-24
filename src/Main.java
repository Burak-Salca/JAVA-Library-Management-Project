import Library.*;
import Users.Admin;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        //Kütüphane ve kadrolar oluşturuldu
        Library library = new Library(new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

        //Yazarlar belirlendi
        Writer writer1 = new Writer(1,"Ahmet Ümit");
        Writer writer2 = new Writer(2,"Lütfü Livaneli");

        //Kategoriler belirlendi
        Category category1 = new Category(1, "Polisiye");
        Category category2 = new Category(2, "Tarih");

        //Kitaplar getirildi
        Book book1 = new Book(1,"book1",writer1,category1, Status.AVAILABLE);
        Book book2 = new Book(2,"book2",writer2,category2,Status.AVAILABLE);
        Book book3 = new Book(3,"book3",writer1,category2,Status.AVAILABLE);
        Book book4 = new Book(4,"book4",writer2,category1,Status.AVAILABLE);
        //Book book5 = new Book(4,"book5",writer2,category1,Status.AVAILABLE);

        //Kütüphane görevlisi kaydı yapıldı
        Admin admin1 = new Admin(1,"admin1",library);

        //Kitaplar kütüpahane sistemine kayıt edildi
        admin1.addBookToLibrary(book1);
        admin1.addBookToLibrary(book2);
        admin1.addBookToLibrary(book3);
        admin1.addBookToLibrary(book4);
        admin1.removeBookFromLibrary(book3.getBookId());
        admin1.addBookToLibrary(book3);

        //İstenilen kitaplar güncellendi
        admin1.updateBookInfo(2,new Book("updatedBook2",writer2,category2,Status.AVAILABLE));
        admin1.updateBookInfo(99,book2);

        System.out.println("***************************************");
        //Yazara göre kitap arama
        admin1.findBooksByWriter(library, writer1.getWriterName());
        System.out.println("***************************************");
        //Kategoriye göre kitap arama
        admin1.findBooksByCategory(library, category1.getCategoryName());
        System.out.println("***************************************");
        //İsme göre kitap arama
        admin1.findBookByName(library, book3.getBookName());
        System.out.println("***************************************");
        //id ye göre kitap arama
        admin1.findBookById(library,99);
        System.out.println("***************************************");

        System.out.println("Library Books:");
        for (Book book : library.getBooks()) {
            System.out.println(book.getBookName()+" "+book.getWriter().getWriterName()+" "+book.getCategory().getCategoryName());
        }

    }
}