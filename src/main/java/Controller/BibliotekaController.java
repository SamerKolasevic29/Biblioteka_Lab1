package Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import data.BibliotekaData;
import model.Pozajmica;
import java.time.LocalDate;


@Controller
public class BibliotekaController {

    private final BibliotekaData bibliotekadata;

    public BibliotekaController(BibliotekaData bibliotekadata) {
        this.bibliotekadata = bibliotekadata;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/loans";
    }

    @GetMapping("/books")
    public String GetBooks(Model model) {
        model.addAttribute("books", bibliotekadata.findAllBooks());
        return "books";
    }

    @GetMapping("/members")
    public String GetMembers(Model model) {
        model.addAttribute("members", bibliotekadata.findAllMembers());
        return "members";
    }

    @GetMapping("/members/{amount}")
    public String GetMmbersMoreThan(@PathVariable int amount, Model model) {
        model.addAttribute("members", bibliotekadata.moreThanParam(amount));
        model.addAttribute("amount", amount);

        return "members-filtered";
    }

    @GetMapping("/loans")
    public String getLoans(Model model) {
        model.addAttribute("loans", bibliotekadata.findAllPozajmice());
        model.addAttribute("members", bibliotekadata.findAllMembers());
        model.addAttribute("books", bibliotekadata.findAllBooks());
        model.addAttribute("newLoan", new Pozajmica());
        return "loans";
    }

    @PostMapping("/loans")
    public String addLoan(@RequestParam Long memberId,
                          @RequestParam Long bookId,
                          @RequestParam String datumPozajmljivanja) {
        Pozajmica loan = new Pozajmica();
        loan.setMember(bibliotekadata.findMember(memberId));
        loan.setBook(bibliotekadata.findBook(bookId));
        loan.setDatumPozajmljivanja(LocalDate.parse(datumPozajmljivanja));
        bibliotekadata.savePozajmica(loan);
        return "redirect:/loans";
    }
}
