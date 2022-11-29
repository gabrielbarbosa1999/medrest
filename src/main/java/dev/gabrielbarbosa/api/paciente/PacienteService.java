package dev.gabrielbarbosa.api.paciente;

import dev.gabrielbarbosa.api.medico.DadosCadastroMedidoDTO;
import dev.gabrielbarbosa.api.medico.Medico;
import dev.gabrielbarbosa.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente cadastrarMedico(DadosCadastroPacienteDTO dados) {
        Paciente paciente = new Paciente(dados);
        return pacienteRepository.save(paciente);
    }

    public Page<DadosListagemPacienteDTO> listarPacientes(Pageable paginacao) {
        return pacienteRepository.findAll(paginacao).map(DadosListagemPacienteDTO::new);
    }

    public void atualizar(DadosAtualizarPacienteDTO dados) {
        Paciente paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizar(dados);
    }

    public void excluir(Long id) {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }

}
