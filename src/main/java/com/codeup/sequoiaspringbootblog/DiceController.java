package com.codeup.sequoiaspringbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String guessPage() {
        return "roll-dice-guess";
    }

    @GetMapping("/roll-dice/{n}")
    public String resultsPage(@PathVariable int n, Model m) {
        m.addAttribute("rand1", (int) Math.floor(Math.random() * 6)+1);
        m.addAttribute("rand2", (int) Math.floor(Math.random() * 6)+1);
        m.addAttribute("rand3", (int) Math.floor(Math.random() * 6)+1);
        m.addAttribute("rand4", (int) Math.floor(Math.random() * 6)+1);
        m.addAttribute("rand5", (int) Math.floor(Math.random() * 6)+1);
        m.addAttribute("rand6", (int) Math.floor(Math.random() * 6)+1);
        m.addAttribute("userGuess", n);
        return "roll-dice-results";
    }
}
