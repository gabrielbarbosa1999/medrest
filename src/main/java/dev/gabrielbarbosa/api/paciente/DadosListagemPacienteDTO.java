package dev.gabrielbarbosa.api.paciente;

import dev.gabrielbarbosa.api.medico.DadosListagemMedicoDTO;

public record DadosListagemPacienteDTO(
        String nome,
        String telefone,
        String email
) {
    public DadosListagemPacienteDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getTelefone(), paciente.getEmail());
    }
}
