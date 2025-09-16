package br.com.senai.Entregas.service;


import br.com.senai.Entregas.repository.EntregaRepository;
import org.springframework.stereotype.Service;

@Service
public class EntregaService {
    // Criando constante para fazer injeção de dependência
    private final EntregaRepository entregaRepository;

    // Realizando Injeção de dependência
    public EntregaService(EntregaRepository entregaRepository){
        this.entregaRepository = entregaRepository;
    }
}
