package br.com.senai.Entregas.service;

import br.com.senai.Entregas.exception.UserNotFoundException;
import br.com.senai.Entregas.model.Usuario;
import br.com.senai.Entregas.model.Veiculo;
import br.com.senai.Entregas.repository.UsuarioRepository;
import br.com.senai.Entregas.repository.VeiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;
    private final UsuarioRepository usuarioRepository;
    public VeiculoService(VeiculoRepository veiculoRepository, UsuarioRepository usuarioRepository){
        this.veiculoRepository = veiculoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // CRUD
    // CREATE
    // Método para cadastrar veiculo
    public Veiculo cadastrarVeiculo(Veiculo novoVeiculo){

        if(novoVeiculo.getUsuario() != null && novoVeiculo.getUsuario().getIdUsuario() != null){
            Integer novoUsuarioId = novoVeiculo.getUsuario().getIdUsuario();
            Usuario novoUsuario = usuarioRepository.findById(novoUsuarioId)
                    .orElseThrow(() -> new UserNotFoundException("Usuário"));
        }
        return veiculoRepository.save(novoVeiculo);
    }

    // READ
    // Método para listar todos os carros
    public List<Veiculo> listarTodos(){
        return veiculoRepository.findAll();
    }

    // Método para buscarPorId
    public Veiculo buscarPorId(Integer id){
        Optional<Veiculo> veiculoBuscado = veiculoRepository.findById(id);
        return veiculoBuscado.orElseThrow(() -> new UserNotFoundException("Veículo"));
    }

    // UPDATE
    // Método para atualizar cadastro
    @Transactional
    public Veiculo atualizarVeiculo(Integer id, Veiculo veiculoNovo){
        Veiculo veiculoExistente = buscarPorId(id);

        // Atualizamos apenas o valores não nulos e preenchidos
        veiculoExistente.setTipo((veiculoNovo.getTipo()!=null && !veiculoNovo.getTipo().isBlank())
                ? veiculoNovo.getTipo() : veiculoExistente.getTipo());
        veiculoExistente.setModelo((veiculoNovo.getModelo() != null && !veiculoNovo.getModelo().isBlank())
            ? veiculoNovo.getModelo() : veiculoExistente.getModelo());
        veiculoExistente.setPlaca((veiculoNovo.getPlaca() != null && !veiculoNovo.getPlaca().isBlank())
            ? veiculoNovo.getPlaca() : veiculoExistente.getPlaca());

        // Verificamos se a informação do novo tipo de usuario realmente foi enviada
        if(veiculoNovo.getUsuario() != null && veiculoNovo.getUsuario().getIdUsuario()!= null){
            Integer novoUsuarioId = veiculoNovo.getUsuario().getIdUsuario();

            // Se não for encontrado um usuário o código já irá parar aqui mesmo
            Usuario novoUsuario = usuarioRepository.findById(novoUsuarioId)
                    .orElseThrow(() -> new UserNotFoundException("Usuário"));

            veiculoExistente.setUsuario(novoUsuario);
        }

        return veiculoRepository.save(veiculoExistente);
    }

    // DELETE
    // Método para deletar por id
    public Veiculo deletarVeiculo(Integer id){
        Veiculo veiculoDeletado = buscarPorId(id);
        veiculoRepository.delete(veiculoDeletado);
        return veiculoDeletado;
    }
}
