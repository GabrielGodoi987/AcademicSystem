package system.academico.academicsystem.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.academico.academicsystem.model.Aluno;
import system.academico.academicsystem.service.AlunoService;

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

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("aluno") Aluno aluno) {
        alunoService.create(aluno);
        return "redirect:/alunos/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Aluno aluno = alunoService.findById(id);
        model.addAttribute("aluno", aluno);
        return "read";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Aluno aluno = alunoService.findById(id);
        model.addAttribute("aluno", aluno);
        return "form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @ModelAttribute("aluno") Aluno aluno) {
        alunoService.update(id, aluno);
        return "redirect:/alunos/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        alunoService.delete(id);
        return "redirect:/alunos/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("nome") String nome,
                         @RequestParam("tipo") String tipo,
                         Model model) {
        List<Aluno> resultado;

        switch (tipo) {
            case "startsWith":
                resultado = alunoService.findByNomeStartingWith(nome);
                break;
            case "endsWith":
                resultado = alunoService.findByNomeEndsWith(nome);
                break;
            case "contains":
            default:
                resultado = alunoService.findByNomeContaining(nome);
                break;
        }

        model.addAttribute("alunos", resultado);
        model.addAttribute("nome", nome);
        model.addAttribute("tipo", tipo);
        return "list";
    }
}
