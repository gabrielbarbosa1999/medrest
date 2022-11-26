package dev.gabrielbarbosa.api.controller;

import dev.gabrielbarbosa.api.medico.DadosCadastroMedidoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedidoDTO dadosCadastroMedido) {
        System.out.println(dadosCadastroMedido);
    }

}
