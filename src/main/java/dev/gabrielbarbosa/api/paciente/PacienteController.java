package dev.gabrielbarbosa.api.paciente;

import dev.gabrielbarbosa.api.medico.DadosCadastroMedidoDTO;
import dev.gabrielbarbosa.api.medico.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPacienteDTO dadosCadastroPaciente) {
        pacienteService.cadastrarMedico(dadosCadastroPaciente);
    }

    @GetMapping
    public Page<DadosListagemPacienteDTO> listarPacientes(@PageableDefault(size = 3, sort = {"nome"}) Pageable paginacao) {
        return pacienteService.listarPacientes(paginacao);
    }

}
