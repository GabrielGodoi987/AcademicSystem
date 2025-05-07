package system.gabrielgodoi.academicsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ra;
    private String nome;
    private String email;
    private String endereco;
    private Date dataNascimento;
    private String periodo;
}
