package system.academico.academicsystem.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import system.academico.academicsystem.model.Aluno;
import system.academico.academicsystem.repositories.AlunoRepository;

import java.time.LocalDate;
import java.util.Arrays;

@RequiredArgsConstructor
@Configuration
@Profile("test")
public class Instanciation implements CommandLineRunner {
    private final AlunoRepository alunoRepository;

    @Override
    public void run(String... args) throws Exception {
        Aluno a1 = new Aluno(null, "Luis Felipe", "luis@teste.com", "Rua Melo Peixoto", LocalDate.of(2009, 6, 16), "Tarde");
        Aluno a2 = new Aluno(null, "Pedro Henrique", "pedro@teste.com", "Rua Restinga", LocalDate.of(2001, 10, 31), "Manhã");
        Aluno a3 = new Aluno(null, "Erica Silva", "erica@teste.com", "Avenida Celso Garcia", LocalDate.of(2000, 4, 9), "Noturno");
        Aluno a4 = new Aluno(null, "Maria Eduarda", "duda@teste.com", "Alamenda Santos", LocalDate.of(1990, 7, 10), "Noturno");
        Aluno a5 = new Aluno(null, "Gabriel Lima", "gabriel@teste.com", "Rua do Programador", LocalDate.of(1950, 3, 18), "Tarde");

        this.alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));
    }
}
