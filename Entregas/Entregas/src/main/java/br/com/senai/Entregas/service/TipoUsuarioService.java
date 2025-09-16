package br.com.senai.Entregas.service;

import br.com.senai.Entregas.model.TipoUsuario;
import br.com.senai.Entregas.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioService {

    // Criando variável para fazer a injeção de dependência
    private final TipoUsuarioRepository tipoUsuarioRepository;

    // Criando método construtor para que o service dependa do service
    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository){
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    // CRUD
    // CREATE
    // Método para cadastrar tipo de usuario
    public TipoUsuario cadastrarTipoUsuario(TipoUsuario tipoUsuario){
        return tipoUsuarioRepository.save(tipoUsuario);
    }
}
