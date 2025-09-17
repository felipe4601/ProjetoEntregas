package br.com.senai.Entregas.controller;


import br.com.senai.Entregas.model.TipoUsuario;
import br.com.senai.Entregas.service.TipoUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tiposuarios")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService){
        this.tipoUsuarioService = tipoUsuarioService;
    }

    // CRUD
    // CREATE
    // Método para cadastrar tipo de usuário
    @PostMapping
    public ResponseEntity<TipoUsuario> cadastrarTipoUsuario(@RequestBody TipoUsuario tipoUsuario){
        tipoUsuarioService.cadastrarTipoUsuario(tipoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuario);
    }

    // READ 
    // Método para listar todos os tipos de usuario
    @GetMapping()
    public ResponseEntity<List<TipoUsuario>> listarTodosUsuarios(){
        List<TipoUsuario> tiposUsuarios = tipoUsuarioService.listarTodos();
        return ResponseEntity.ok(tiposUsuarios);
    }

    // Método para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> buscarPorId(@PathVariable Integer id){
        TipoUsuario tipoUsuarioBuscado = tipoUsuarioService.buscarPorId(id);
        if(tipoUsuarioBuscado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoUsuarioBuscado);
    }

    // Método para atualizar tipo de usuário
    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> atualizarTipoUsuario(@PathVariable Integer id, @RequestBody TipoUsuario tipoUsuario){
        TipoUsuario tipoUsuarioAtualizado = tipoUsuarioService.atualizarTipoUsuario(id, tipoUsuario);
        if(tipoUsuarioAtualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoUsuarioAtualizado);
    }
}
