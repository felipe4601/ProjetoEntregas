package br.com.senai.Entregas.controller;


import br.com.senai.Entregas.service.VeiculoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    // Criando constante para realizar injeção de dependência
    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }
}
