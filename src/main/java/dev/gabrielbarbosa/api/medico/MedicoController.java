package dev.gabrielbarbosa.api.medico;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedidoDTO dadosCadastroMedido) {
        medicoService.cadastrarMedico(dadosCadastroMedido);
    }

    @GetMapping
    public Page<DadosListagemMedicoDTO> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao) {
        return medicoService.listarMedicos(paginacao);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizarMedicoDTO dados) {
        medicoService.atualizarMedico(dados);
    }



}
