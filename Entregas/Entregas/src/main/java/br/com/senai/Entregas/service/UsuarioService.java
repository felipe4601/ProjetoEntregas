package br.com.senai.Entregas.service;


import br.com.senai.Entregas.model.Usuario;
import br.com.senai.Entregas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    // CRUD
    // CREATE
    // Método para cadastrar usuário
    public Usuario cadastrarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }

    // READ
    // Método para cadatrar todos os usuários
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    // Método para buscar por id
    public Usuario buscarPorId(Integer id){
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(id);

        return usuarioBuscado.orElse(null);
    }

    // UPDATE
    // Método para atualizar usuario
    public Usuario atualizarUsuario(Integer id, Usuario usuario){
        Usuario usuarioExistente = buscarPorId(id);
        if(usuarioExistente == null){
            return null;
        }

        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setNome(usuario.getSenha());
        usuarioExistente.setTipoUsuario(usuario.getTipoUsuario());
        return usuarioRepository.save(usuarioExistente);
    }

}
