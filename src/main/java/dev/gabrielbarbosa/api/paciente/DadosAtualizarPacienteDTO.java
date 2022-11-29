package dev.gabrielbarbosa.api.paciente;

import dev.gabrielbarbosa.api.endereco.DadosEnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPacienteDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO endereco
) {
}
