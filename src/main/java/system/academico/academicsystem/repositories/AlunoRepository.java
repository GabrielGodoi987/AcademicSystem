package system.academico.academicsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.academico.academicsystem.model.Aluno;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Aluno findByNome(String nome);
    Optional<List<Aluno>> findByNomeStartingWith(String nome);
    Optional<List<Aluno>> findByNomeEndingWith(String nome);
    Optional<List<Aluno>> findByNomeContaining(String nome);
}
