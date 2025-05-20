package system.gabrielgodoi.academicsystem.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import system.gabrielgodoi.academicsystem.repositories.AlunoRepository;

@RequiredArgsConstructor
@Controller
@RequestMapping("/alunos")
public class AlunoWebController {

    private final AlunoRepository alunoRepository;

    @GetMapping("index")
    public String index(Model model, @RequestParam("nome") String nome) {
        model.addAttribute("nome", nome);
        return "index";
    }
}
