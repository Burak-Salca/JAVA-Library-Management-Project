package Library;

import Users.Admin;
import Users.Member;

import java.util.List;

public class Library {

    private List<Admin> admins;
    private List<Member> members;
    private List<Book> books;

    public Library(List<Admin> admins, List<Member> members, List<Book> books) {
        this.admins = admins;
        this.members = members;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }


}
