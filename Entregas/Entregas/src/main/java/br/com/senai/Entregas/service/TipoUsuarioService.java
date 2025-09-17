package br.com.senai.Entregas.service;

import br.com.senai.Entregas.model.TipoUsuario;
import br.com.senai.Entregas.repository.TipoUsuarioRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    // Método para cadastrar tipo de usuário
    public TipoUsuario cadastrarTipoUsuario(TipoUsuario tipoUsuario){
        tipoUsuarioRepository.save(tipoUsuario);
        return tipoUsuario;
    }

    // READ
    // Método para listar todos os tipos de usuários
    public List<TipoUsuario> listarTodos(){
        return tipoUsuarioRepository.findAll();
    }

    // Método para buscar por id
    public TipoUsuario buscarPorId(Integer id){
        Optional<TipoUsuario> tipoUsuarioBuscado = tipoUsuarioRepository.findById(id);
        return tipoUsuarioBuscado.orElse(null);
    }
    // UPDATE
    // Método para atualizar tipo de usuário
    public TipoUsuario atualizarTipoUsuario(Integer id, TipoUsuario tipoUsuario){
        TipoUsuario tipoUsuarioExistente = buscarPorId(id);
        if(tipoUsuarioExistente == null){
            return null;
        }

        tipoUsuarioExistente.setDescricao(tipoUsuario.getDescricao());

        return tipoUsuarioRepository.save(tipoUsuarioExistente);
    }
    // DELETE
    // Método para deletar tipo de usuário
    public TipoUsuario deletarTipoUsuario(Integer id){
        TipoUsuario tipoUsuarioDeletado = buscarPorId(id);
        if(tipoUsuarioDeletado == null){
            return null;
        }
        tipoUsuarioRepository.delete(tipoUsuarioDeletado);
        return tipoUsuarioDeletado;
    }
    
}
