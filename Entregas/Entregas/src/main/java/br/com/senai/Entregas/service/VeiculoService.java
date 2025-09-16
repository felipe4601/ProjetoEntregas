package br.com.senai.Entregas.service;

import br.com.senai.Entregas.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    // Criando constante para realizar injeção de dependência
    private final VeiculoRepository veiculoRepository;

    // Realizando injeção de dependência, através do método construtor

    public VeiculoService(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }
}
