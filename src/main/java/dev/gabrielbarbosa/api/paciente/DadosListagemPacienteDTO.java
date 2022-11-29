package dev.gabrielbarbosa.api.paciente;

public record DadosListagemPacienteDTO(
        Long id,
        String nome,
        String telefone,
        String email
) {
    public DadosListagemPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEmail());
    }
}
