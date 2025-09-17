package br.com.senai.Entregas.controller;


import br.com.senai.Entregas.model.Veiculo;
import br.com.senai.Entregas.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    // CRUD
    // CREATE
    // Método para cadastrar carro
    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo){
        veiculoService.cadastrarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

    // READ
    // Método para listar todos os carros
    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodosOsCarros(){
        List<Veiculo> veiculos =  veiculoService.listarTodos();
        return ResponseEntity.ok(veiculos);
    }
    // Método para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Integer id){
        Veiculo veiculo = veiculoService.buscarPorId(id);
        if(veiculo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(veiculo);
    }

    // Métodod para atualizar veiculo
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Integer id, @RequestBody Veiculo veiculo){
        Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(id, veiculo);
        if(veiculoAtualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(veiculoAtualizado);

    }

    // DELETE
    // Método para deletar veículo por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarVeiculo(@PathVariable Integer id){
        Veiculo veiculoDeletado = veiculoService.deletarVeiculo(id);
        if(veiculoDeletado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    
}
