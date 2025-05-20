package system.academico.academicsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import system.academico.academicsystem.model.Aluno;
import system.academico.academicsystem.service.AlunoService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(){
        List<Aluno> alunos = this.alunoService.findAll();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Aluno> findByNome(@PathVariable("nome") String nome){
        Aluno aluno = this.alunoService.findByNome(nome);
        return ResponseEntity.ok().body(aluno);
    }

        @GetMapping("/primeiro-nome/{nome}")
    public ResponseEntity<List<Aluno>> findByFirstName(@PathVariable("nome") String nome){
        List<Aluno> alunoList = this.alunoService.findByNomeStartingWith(nome);
        return ResponseEntity.ok().body(alunoList);
    }

    @GetMapping("/ultimo-nome/{nome}")
    public ResponseEntity<List<Aluno>> findByEndsWith(@PathVariable("nome") String nome){
        List<Aluno> alunoList = this.alunoService.findByNomeEndsWith(nome);
        return ResponseEntity.ok().body(alunoList);
    }

    @GetMapping("/contem-nome/{nome}")
    public ResponseEntity<List<Aluno>> findByContainsNome(@PathVariable("nome") String nome){
        List<Aluno> alunoList = this.alunoService.findByNomeContaining(nome);
        return ResponseEntity.ok().body(alunoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable("id") int id){
        Aluno aluno = this.alunoService.findById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody  Aluno aluno){
        Aluno aluno1 = this.alunoService.create(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(aluno1.getRa()).toUri();
        return ResponseEntity.created(uri).body(aluno1);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable("id") int id, @RequestBody Aluno aluno){
        Aluno aluno1 = this.alunoService.update(id, aluno);
        return ResponseEntity.ok().body(aluno1);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        this.alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
