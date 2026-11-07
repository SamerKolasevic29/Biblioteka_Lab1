package data;

import model.Book;
import model.Member;
import model.Pozajmica;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotekaData implements CommandLineRunner {
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final PozajmicaRepository pozajmicaRepository;

    public BibliotekaData(MemberRepository memberRepository,
                          BookRepository bookRepository,
                          PozajmicaRepository pozajmicaRepository) {
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
        this.pozajmicaRepository = pozajmicaRepository;
    }

    @Override
    public void run(String... args) {
        if (memberRepository.count() == 0) {
            memberRepository.save(new Member(null, "Tajra", "Tasic", 999));
            memberRepository.save(new Member(null, "Samer", "Kolasevic", 200));
        }
        if (bookRepository.count() == 0) {
            bookRepository.save(new Book(null, "1984", "Orwell", 40));
            bookRepository.save(new Book(null, "Zivotinjska farma", "Orwell", 30));
            bookRepository.save(new Book(null, "Samom sebi", "Marko Aurelije", 12));
        }
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Pozajmica savePozajmica(Pozajmica pozajmica) {
        return pozajmicaRepository.save(pozajmica);
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<Pozajmica> findAllPozajmice() {
        return pozajmicaRepository.findAll();
    }

    public List<Member> moreThanParam(int param) {
        return memberRepository.findAll().stream()
                .filter(member -> member.getCash() >= param)
                .toList();
    }

    public Member findMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member nije pronađen: " + id));
    }

    public Book findBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book nije pronađen: " + id));
    }
}
