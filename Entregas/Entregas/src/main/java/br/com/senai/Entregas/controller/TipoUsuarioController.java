package br.com.senai.Entregas.controller;


import br.com.senai.Entregas.model.TipoUsuario;
import br.com.senai.Entregas.service.TipoUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipo-usuarios")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService){
        this.tipoUsuarioService = tipoUsuarioService;
    }

    // CRUD
    // CREATE
    // Método para cadastrar tipos de usuário
    @PostMapping
    public ResponseEntity<TipoUsuario> cadastrarTipoUsuario(@RequestBody TipoUsuario tipoUsuario){
        tipoUsuarioService.cadastrarTipoUsuario(tipoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuario);
    }
}
