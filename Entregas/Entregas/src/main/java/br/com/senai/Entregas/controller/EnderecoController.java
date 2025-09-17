package br.com.senai.Entregas.controller;

import java.util.List;

import br.com.senai.Entregas.model.Endereco;
import br.com.senai.Entregas.service.EnderecoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    // CRUD
    // CREATE
    // Método para cadastrar endereco
    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco){
        enderecoService.cadastrarEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    // READ 
    // Método para listar todos os endereços
    @GetMapping
    public ResponseEntity<List<Endereco>> listarTodosEnderecos(){
        List<Endereco> enderecos = enderecoService.listarTodos();
        return ResponseEntity.ok(enderecos);
    }

    // Método para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Integer id){
        Endereco enderecoBuscado = enderecoService.buscarPorId(id);
        if(enderecoBuscado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(enderecoBuscado);

    }

    // UPDATE
    // Método para atualizar endereco
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Integer id, @RequestBody Endereco endereco){
        Endereco enderecoAtualizado = enderecoService.atualizarEndereco(id, endereco);
        if(enderecoAtualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(enderecoAtualizado);
    }

    // DELETE
    // Método para deletar endereço de entrega
    @DeleteMapping
    public ResponseEntity<?> deletarEndereco(@PathVariable Integer id){
        Endereco enderecoDeletado = enderecoService.deletarEndereco(id);
        if(enderecoDeletado == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
