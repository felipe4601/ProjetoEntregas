package br.com.senai.Entregas.controller;


import br.com.senai.Entregas.repository.EntregaRepository;
import br.com.senai.Entregas.service.EntregaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {
    // Criando constante para ralizar injeção de dependência
    private final EntregaService entregaService;

    // Realizando injeção de dependência, através do construtor
    public EntregaController(EntregaService entregaService){
        this.entregaService = entregaService;
    }
}
