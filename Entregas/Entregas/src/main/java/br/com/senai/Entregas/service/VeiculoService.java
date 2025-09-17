package br.com.senai.Entregas.service;

import br.com.senai.Entregas.model.Veiculo;
import br.com.senai.Entregas.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }

    // CRUD
    // CREATE
    // Método para cadastrar veiculo
    public Veiculo cadastrarVeiculo(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    // READ
    // Método para listar todos os carros
    public List<Veiculo> listarTodos(){
        return veiculoRepository.findAll();
    }

    // Método para buscarPorId
    public Veiculo buscarPorId(Integer id){
        Optional<Veiculo> veiculoBuscado = veiculoRepository.findById(id);
        return veiculoBuscado.orElse(null);
    }

    // UPDATE
    // Método para atualizar cadastro
    public Veiculo atualizarVeiculo(Integer id, Veiculo veiculo){
        Veiculo veiculoExistente = buscarPorId(id);
        if(veiculoExistente == null){
            return null;
        }
        veiculoExistente.setModelo(veiculo.getModelo());
        veiculoExistente.setPlaca(veiculo.getPlaca());
        veiculoExistente.setTipo(veiculo.getTipo());
        veiculoExistente.setUsuario(veiculo.getUsuario());

        return veiculoRepository.save(veiculoExistente);
    }

    // DELETE
    // Método para deletar por id
}
