package dev.gabrielbarbosa.api.endereco;

public record DadosEnderecoDTO (
    String logradouro,
    String bairro,
    String cep,
    String cidade,
    String uf,
    String numero,
    String complemento) {
}
