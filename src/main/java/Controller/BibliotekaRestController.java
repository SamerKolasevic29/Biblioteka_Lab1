package Controller;

import data.BibliotekaData;
import model.Book;
import model.Member;
import model.Pozajmica;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BibliotekaRestController {
    private final BibliotekaData bibliotekadata;

    public BibliotekaRestController(BibliotekaData bibliotekadata) {
        this.bibliotekadata = bibliotekadata;
    }

    @GetMapping("/loans")
    public List<Pozajmica> getLoans() {
        return bibliotekadata.findAllPozajmice();
    }

    @GetMapping("/members")
    public List<Member> getMembers() {
        return bibliotekadata.findAllMembers();
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bibliotekadata.findAllBooks();
    }
}
