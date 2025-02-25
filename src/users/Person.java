package users;

import library.Library;

import java.util.Objects;

public class Person {

    private static int idCounter = 1;
    private int id;
    private String name;
    private Library library;

    public Person(  String name, Library library) {
        this.id = idCounter++;
        this.name = name;
        this.library = library;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(library, person.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, library);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", library=" + library +
                '}';
    }
}
