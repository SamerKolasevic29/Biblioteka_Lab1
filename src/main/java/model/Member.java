package model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private Long id;
    private String name;
    private String surname;
    private int cash;

    private List<Book>  books = new ArrayList<>();

    public Member() {};

    public Member(Long Id, String Name, String Surname, int Cash) {
        id = Id;
        name = Name;
        surname = Surname;
        cash = Cash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}


