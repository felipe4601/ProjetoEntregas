package br.com.senai.Entregas.service;

import br.com.senai.Entregas.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    // Criando constante para realizar injeção de dependência
    private final EnderecoRepository enderecoRepository;
    // Realizando injeção de dependência

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }
}
