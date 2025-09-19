package br.com.senai.Entregas.controller;


import br.com.senai.Entregas.model.Veiculo;
import br.com.senai.Entregas.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    // Aqui nós vamos interceptar as mensagens de erro geradas pelas anotações validadoras
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class) //
    // Será acionado sempre que receber um bad Request, toda vez que houver um methodArgumentNotValidException
    public Map<String, String> hadleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // pegar a exceção e capturar as informações, que estão dentro dela
            String fieldName = ((FieldError) error).getField(); // pegar o nome do meu campo
            String errorMessage = error.getDefaultMessage();  // pegar mensagem do erro
            errors.put(fieldName, errorMessage); // adicionar na minha lista de erros, o nome do campo e a mensagem de erro
        });
        return errors;
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
        return ResponseEntity.ok(veiculo);
    }

    // Métodod para atualizar veiculo
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Integer id, @RequestBody @Valid Veiculo veiculo){
        Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(id, veiculo);

        return ResponseEntity.ok(veiculoAtualizado);



    }

    // DELETE
    // Método para deletar veículo por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarVeiculo(@PathVariable Integer id){
        Veiculo veiculoDeletado = veiculoService.deletarVeiculo(id);

        return ResponseEntity.noContent().build();
    }

    
}
