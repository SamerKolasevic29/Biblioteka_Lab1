package data;

import model.Book;
import model.Member;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Filter;

public class BibliotekaData {
    private final Map<Long, Member> members = new LinkedHashMap<>();
    private final Map<Long, Book> books = new LinkedHashMap<>();


    public BibliotekaData() {
        SaveBook(new Book(222L, "1984", "Orwell", 40));
        SaveBook(new Book(333L, "Zivotinjska farma", "Orwell", 30));
        SaveBook(new Book(444L, "SAmom sebi", "Marko Aurelije", 12));

        SaveMember(new Member(123L, "Tajra", "Tasic", 999));
        SaveMember(new Member(456L, "Samer", "Kolasevic", 200));
    }

    public Member SaveMember(Member m) {
        members.put(m.getId(), m);
        return m;
    }

    public Book SaveBook(Book b) {
        books.put(b.getId(), b);
        return b;
    }

    public List<Member> FindallMembers() {return new ArrayList<>(members.values());}
    public List<Book>   FindAllBooks() {return new ArrayList<>(books.values());}
    public List<Member> MoreThanParam(int param) {

        List<Member> FilteredList = new ArrayList<Member>();

        for(Member m : members.values()) {
            if(m.getCash() >= param) {
                FilteredList.add(m);}
        }

        return FilteredList;

    }
}
