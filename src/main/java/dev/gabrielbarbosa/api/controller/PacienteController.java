package dev.gabrielbarbosa.api.controller;

import dev.gabrielbarbosa.api.medico.DadosCadastroMedidoDTO;
import dev.gabrielbarbosa.api.medico.MedicoService;
import dev.gabrielbarbosa.api.paciente.DadosAtualizarPacienteDTO;
import dev.gabrielbarbosa.api.paciente.DadosCadastroPacienteDTO;
import dev.gabrielbarbosa.api.paciente.DadosListagemPacienteDTO;
import dev.gabrielbarbosa.api.paciente.PacienteService;
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

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizarPacienteDTO dados) {
        pacienteService.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        pacienteService.excluir(id);
    }

}
