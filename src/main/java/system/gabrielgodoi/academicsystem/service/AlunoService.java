package system.gabrielgodoi.academicsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.gabrielgodoi.academicsystem.exceptions.NotFoundException;
import system.gabrielgodoi.academicsystem.model.Aluno;
import system.gabrielgodoi.academicsystem.repositories.AlunoRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public List<Aluno> findAll(){
        return this.alunoRepository.findAll();
    }

    public Aluno findById(int id){
        return this.alunoRepository.findById(id).orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
    }

    public Aluno findByNome(String nome){
        return this.alunoRepository.findByNome(nome);
    }

    public Aluno create(Aluno aluno){
        return this.alunoRepository.save(aluno);
    }

    public Aluno update(int id, Aluno update){
        Aluno entity = this.alunoRepository.getReferenceById(id);
        this.updateData(entity, update);
        return this.alunoRepository.save(entity);
    }

    public void delete(int id){
        Aluno aluno = this.findById(id);
        if (aluno == null){
            throw new NotFoundException("Aluno não encontrado");
        }
        this.alunoRepository.deleteById(id);
    }

    public void updateData(Aluno entity, Aluno update){
        entity.setNome(update.getNome());
        entity.setEmail(update.getEmail());
        entity.setEndereco(update.getEndereco());
        entity.setPeriodo(update.getPeriodo());
        entity.setDataNascimento(update.getDataNascimento());
    }
}
