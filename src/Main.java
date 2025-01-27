import library.*;
import users.Admin;


public class Main {
    public static void main(String[] args) {

        //Kütüphane ve kadrolar oluşturuldu
        Library library = new Library();

        //Kitaplar getirildi
        Book book1 = new Book(1,"book1","Ahmet Ümit","Polisiye");
        Book book2 = new Book(2,"book2","Lütfü Livaneli","Polisiye");
        Book book3 = new Book(3,"book3","Namık Kemal","Edebiyat");
        Book book4 = new Book(4,"book4","Atatürk","Söylev");
        Book bookDuplicate = new Book(1,"bookDuplicate", "Author One", "Category One");


        //Kütüphane görevlisi kaydı yapıldı
        Admin admin1 = new Admin(1,"admin1",library);

        //Kitaplar kütüpahane sistemine eklenmesi-çıkarılması-güncellenmesi
        admin1.addBookToLibrary(library,book1);
        admin1.addBookToLibrary(library,book2);
        admin1.addBookToLibrary(library,book3);
        admin1.addBookToLibrary(library,book4);
        admin1.addBookToLibrary(library, bookDuplicate);
        //admin1.removeBookFromLibrary(library,book3.getBookId());
        //admin1.removeBookFromLibrary(library,book2.getBookId());
        admin1.updateBookInfo(library, book3.getBookId(), new Book("updatedBook3","Cemal Süreyya","Şiir"));
        //admin1.removeBookFromLibrary(library,book3.getBookId());
        admin1.findBookById(library,1);
        admin1.findBooksByCategory(library,"polisiye");

        System.out.println("\n***************************************");
        //Kütüphanedeki kitaplar
        System.out.println("\nKütüphanedeki Kitaplar::");
        for (Book book : library.getBooks()) {
            System.out.println("ID: " + book.getBookId() + " - " +book.getBookName() + " - " + book.getAuthor() + " - " + book.getCategory() + " - " + book.getStatus());
        }
        System.out.println("\n***************************************");
        //Kütüphanedeki kategoriler
        System.out.println("\nKategoriler:");
        for (String category : library.getCategories()) {
            System.out.println(category);
        }
        System.out.println("\n***************************************");
        //Kütüphanedi yazarlar
        System.out.println("\nYazarlar:");
        for (String author : library.getAuthors()) {
            System.out.println(author);
        }
        System.out.println("\n***************************************");
        //Admin
        /*İstenilen kitaplar güncellendi
        admin1.updateBookInfo(2,new Book("updatedBook2",writer2,category2,Status.AVAILABLE));
        admin1.updateBookInfo(99,book2);
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
        */


    }
}