package Controller;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import data.BibliotekaData;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BibliotekaController {

    private final BibliotekaData bibliotekadata = new BibliotekaData();

    @GetMapping("/books")
    public String GetBooks(Model model) {
        model.addAttribute("books", bibliotekadata.FindAllBooks());
        return "books";
    }

    @GetMapping("/members")
    public String GetMembers(Model model) {
        model.addAttribute("members", bibliotekadata.FindallMembers());
        return "members";
    }

    @GetMapping("/members/{amount}")
    public String GetMmbersMoreThan(@PathVariable int amount, Model model) {
        model.addAttribute("members", bibliotekadata.MoreThanParam(amount));
        model.addAttribute("amount", amount);

        return "members-filtered";
    }

}
