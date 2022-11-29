package dev.gabrielbarbosa.api.medico;

import dev.gabrielbarbosa.api.endereco.DadosEnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedicoDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO endereco) {
}
