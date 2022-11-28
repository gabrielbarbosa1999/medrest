package dev.gabrielbarbosa.api.medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico cadastrarMedico(DadosCadastroMedidoDTO dados) {
        Medico medico = new Medico(dados);
        return medicoRepository.save(medico);
    }

    public Page<DadosListagemMedicoDTO> listarMedicos(Pageable paginacao) {
        return medicoRepository.findAll(paginacao)
                .map(DadosListagemMedicoDTO::new);
    }

}
