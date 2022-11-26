package dev.gabrielbarbosa.api.medico;

import dev.gabrielbarbosa.api.endereco.DadosEnderecoDTO;
public record DadosCadastroMedidoDTO (String nome, String emaiil, String crm, Especialidade especialidade, DadosEnderecoDTO endereco) {
}
