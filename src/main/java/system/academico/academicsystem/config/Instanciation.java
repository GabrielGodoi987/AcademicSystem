package system.academico.academicsystem.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import system.academico.academicsystem.model.Aluno;
import system.academico.academicsystem.repositories.AlunoRepository;

import java.util.Arrays;
import java.util.Date;

@RequiredArgsConstructor
@Configuration
@Profile("test")
public class Instanciation implements CommandLineRunner {
    private final AlunoRepository alunoRepository;

    @Override
    public void run(String... args) throws Exception {
        Aluno a1 = new Aluno(null, "Luis Felipe", "luis@teste.com", "Rua Melo Peixoto", new Date(2009 - 1900, 5, 16), "Diurno");
        Aluno a2 = new Aluno(null, "Pedro Henrique", "pedro@teste.com", "Rua Restinga", new Date(2001 - 1900, 9, 31), "Vespertino");
        Aluno a3 = new Aluno(null, "Erica Silva", "erica@teste.com", "Avenida Celso Garcia", new Date(2000 - 1900, 3, 9), "Noturno");
        Aluno a4 = new Aluno(null, "Maria Eduarda", "duda@teste.com", "Alamenda Santos", new Date(1990 - 1900, 6, 10), "Noturno");
        Aluno a5 = new Aluno(null, "Gabriel Lima", "gabriel@teste.com", "Rua do Programador", new Date(1950 - 1900, 2, 18), "Diurno");

        this.alunoRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));
    }
}
