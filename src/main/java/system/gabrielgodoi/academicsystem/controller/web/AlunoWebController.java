package system.gabrielgodoi.academicsystem.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import system.gabrielgodoi.academicsystem.model.Aluno;
import system.gabrielgodoi.academicsystem.repositories.AlunoRepository;
import system.gabrielgodoi.academicsystem.service.AlunoService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/alunos")
public class AlunoWebController {

    private final AlunoService alunoService;

    @GetMapping("index")
    public String index(Model model, @RequestParam(value = "nome", required = false) String nome) {
        model.addAttribute("nome", nome);
        return "index";
    }

    @GetMapping("/list")
    public String listAll(Model model){
        List<Aluno> alunoList = this.alunoService.findAll();
        model.addAttribute("alunos", alunoList);
        return "list";
    }
}
