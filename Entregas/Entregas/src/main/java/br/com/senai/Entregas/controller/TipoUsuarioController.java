package br.com.senai.Entregas.controller;


import br.com.senai.Entregas.service.TipoUsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entregas")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService){
        this.tipoUsuarioService = tipoUsuarioService;
    }
}
