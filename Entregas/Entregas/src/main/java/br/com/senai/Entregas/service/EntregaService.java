package br.com.senai.Entregas.service;

import java.util.List;
import java.util.Optional;

import br.com.senai.Entregas.model.Entrega;
import br.com.senai.Entregas.repository.EntregaRepository;

import org.springframework.stereotype.Service;

@Service
public class EntregaService {
    private final EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository entregaRepository){
        this.entregaRepository = entregaRepository;
    }

    // CRUD
    // CREATE
    // Método para cadastrar entrega
    public Entrega cadastrarEntrega(Entrega entrega){
        entregaRepository.save(entrega);
        return entrega;
    }

    // READ 
    // Método para listar todos 
    public List<Entrega> listarTodos(){
        return entregaRepository.findAll();
    }

    // Método para buscar por id
    public Entrega buscarPorId(Integer id){
        Optional<Entrega> entregaBuscada = entregaRepository.findById(id);
        return entregaBuscada.orElse(null);
    }

    // UPDATE
    // Método para atualizar entrega
    public Entrega atualizarEntrega(Integer id, Entrega entrega){
        Entrega entregaExistente = buscarPorId(id);
        if(entregaExistente == null){
            return null;
        }

        entregaExistente.setDataPedido(entrega.getDataPedido());
        entregaExistente.setDescricaoProduto(entrega.getDescricaoProduto());
        entregaExistente.setEndereco(entrega.getEndereco());
        entregaExistente.setStatus(entrega.getStatus());
        entregaExistente.setUsuario(entrega.getUsuario());

        return entregaRepository.save(entregaExistente);
    }
}
