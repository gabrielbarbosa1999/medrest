package dev.gabrielbarbosa.api.medico;

import dev.gabrielbarbosa.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Medico")
@Table(name = "tb_medicos")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedidoDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizar(DadosAtualizarMedicoDTO dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            endereco.atualizar(dados.endereco());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Medico medico = (Medico) o;
        return id != null && Objects.equals(id, medico.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
