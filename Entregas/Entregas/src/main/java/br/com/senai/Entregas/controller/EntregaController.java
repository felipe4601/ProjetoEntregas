package br.com.senai.Entregas.controller;


import java.util.List;

import br.com.senai.Entregas.model.Entrega;
import br.com.senai.Entregas.service.EntregaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/entregas")
public class EntregaController {
    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService){
        this.entregaService = entregaService;
    }

    // CRUD
    // CREATE
    // Método para cadastrar entrega
    @PostMapping
    public ResponseEntity<Entrega> cadastrarEntrega(@RequestBody Entrega entrega){
        entregaService.cadastrarEntrega(entrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrega);
    }

    // READ 
    // Métodos para listar todas as entregas
    @GetMapping
    public ResponseEntity<List<Entrega>> listarTodasEntregas(){
        List<Entrega> entregas = entregaService.listarTodos();
        return ResponseEntity.ok(entregas);
    }

    // Método par buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscarPorId(@PathVariable Integer id){
        Entrega entregaBuscada = entregaService.buscarPorId(id);
        if(entregaBuscada == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entregaBuscada);
    }

    // UPDATE
    // Método para atualizar entrega
    @PutMapping("/{id}")
    public ResponseEntity<Entrega> atualizarEntrega(@PathVariable Integer id, @RequestBody Entrega entrega){
        Entrega entregaAtualizada = entregaService.atualizarEntrega(id, entrega);
        if(entregaAtualizada == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entregaAtualizada);
    }

    // DELETE
    // Método para deletar entrega
    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarEntrega(@PathVariable Integer id){
        Entrega entregaDeletada = entregaService.deletarEntrega(id);
        if(entregaDeletada == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
