package system.gabrielgodoi.academicsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import system.gabrielgodoi.academicsystem.model.Aluno;
import system.gabrielgodoi.academicsystem.service.AlunoService;

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
