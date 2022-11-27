package dev.gabrielbarbosa.api.medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico cadastrarMedico(DadosCadastroMedidoDTO dados) {
        Medico medico = new Medico(dados);
        return medicoRepository.save(medico);
    }

}
