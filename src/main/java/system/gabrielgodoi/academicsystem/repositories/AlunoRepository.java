package system.gabrielgodoi.academicsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.gabrielgodoi.academicsystem.model.Aluno;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Aluno findByNome(String nome);

    List<Aluno> findByNomeStartingWith(String nome);
    List<Aluno> findByNomeEndingWith(String nome);
    List<Aluno> findNomeContains(String nome);
}
