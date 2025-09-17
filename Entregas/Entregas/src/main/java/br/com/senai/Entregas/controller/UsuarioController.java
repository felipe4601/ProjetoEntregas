package br.com.senai.Entregas.controller;


import br.com.senai.Entregas.model.Usuario;
import br.com.senai.Entregas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    // CRUD
    // CREATE
    // Método para cadastrar usuário
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    // READ
    // Método para listar todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodosUsuarios(){
        List<Usuario> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    // Método para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id){
        Usuario usuarioBuscado = usuarioService.buscarPorId(id);
        if(usuarioBuscado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioBuscado);
    }

    // UPDATE
    // Método para atualizar usuário
    @PostMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario){
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
        if(usuarioAtualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioAtualizado);
    }

}
