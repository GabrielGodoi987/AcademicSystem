package system.academico.academicsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.academico.academicsystem.exceptions.NotFoundException;
import system.academico.academicsystem.model.Aluno;
import system.academico.academicsystem.repositories.AlunoRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return this.alunoRepository.findAll();
    }

    public Aluno findById(int id) {
        return this.alunoRepository.findById(id).orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
    }

    public Aluno findByNome(String nome) {
        return this.alunoRepository.findByNome(nome);
    }

    public List<Aluno> findByNomeStartingWith(String nome) {
        return this.alunoRepository.findByNomeStartingWith(nome).orElseThrow(
                () -> new NotFoundException("no one starts with: " + nome + " first name")
        );
    }

    public List<Aluno> findByNomeEndsWith(String nome) {
        return this.alunoRepository.findByNomeEndingWith(nome).orElseThrow(
                () -> new NotFoundException("no one starts with: " + nome + " first name")
        );
    }

    public List<Aluno> findByNomeContaining(String nome) {
        return this.alunoRepository.findByNomeContaining(nome).orElseThrow(
                () -> new NotFoundException("no one starts with: " + nome + " first name")
        );
    }

    public Aluno create(Aluno aluno) {
        return this.alunoRepository.save(aluno);
    }

    public Aluno update(int id, Aluno update) {
        Aluno entity = this.alunoRepository.getReferenceById(id);
        this.updateData(entity, update);
        return this.alunoRepository.save(entity);
    }

    public void delete(int id) {
        Aluno aluno = this.findById(id);
        if (aluno == null) {
            throw new NotFoundException("Aluno não encontrado");
        }
        this.alunoRepository.deleteById(id);
    }

    public void updateData(Aluno entity, Aluno update) {
        entity.setNome(update.getNome());
        entity.setEmail(update.getEmail());
        entity.setEndereco(update.getEndereco());
        entity.setPeriodo(update.getPeriodo());
        entity.setDataNascimento(update.getDataNascimento());
    }
}
