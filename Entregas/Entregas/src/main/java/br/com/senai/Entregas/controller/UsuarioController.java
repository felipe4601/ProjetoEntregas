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
    // criando constante para armazenar o service
    private final UsuarioService usuarioService;

    // Criando construtor para injeção de dependência
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
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok().body(usuarios);
    }

    // Método para mostrar usuário por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Integer id){
        Usuario usuario = usuarioService.buscarPorId(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

}
