package Library;

import Users.Admin;
import Users.Member;

import java.util.*;

public class Library {

    private Set<String> authors;
    private Set<String> categories;
    private List<Book> books;
    private List<Admin> admins;  // Admin listesi
    private List<Member> members;  // Member listesi

    public Library() {
        this.books = new ArrayList<>();
        authors = new HashSet<>();
        categories = new HashSet<>();
        this.admins = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public List<Member> getMembers() {
        return members;
    }
}
