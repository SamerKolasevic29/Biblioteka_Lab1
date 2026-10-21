package Controller;

import ch.qos.logback.core.model.Model;
import data.BibliotekaData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

    @GetMapping("/members/{amout}")
    public String GetMmbersMoreThan(@PathVariable int amout, Model model) {
        model.addAttribute("members", bibliotekadata.MoreThanParam(amout));
        model.addAttribute("amout", amout);

        return "members-filtered";
    }

}
