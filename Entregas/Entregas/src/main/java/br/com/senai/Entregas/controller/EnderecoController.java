package br.com.senai.Entregas.controller;


import br.com.senai.Entregas.repository.EnderecoRepository;
import br.com.senai.Entregas.service.EnderecoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    // criando constante para realizar injeção de dependência
    private final EnderecoService enderecoService;

    // Realizando injeção de dependência
    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }
}
