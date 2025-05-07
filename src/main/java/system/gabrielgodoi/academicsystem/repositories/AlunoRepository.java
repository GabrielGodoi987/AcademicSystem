package system.gabrielgodoi.academicsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.gabrielgodoi.academicsystem.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
