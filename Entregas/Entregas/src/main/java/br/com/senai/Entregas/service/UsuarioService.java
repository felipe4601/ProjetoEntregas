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

    //CREATE

    // Método para cadastrar usuário
    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    // READ
    // Método para listar usuários
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    // Método para buscar por id
    public Usuario buscarPorId(Integer id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }
}
