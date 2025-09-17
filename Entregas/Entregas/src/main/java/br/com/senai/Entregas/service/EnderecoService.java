package br.com.senai.Entregas.service;

import java.util.List;
import java.util.Optional;

import br.com.senai.Entregas.model.Endereco;
import br.com.senai.Entregas.repository.EnderecoRepository;

import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    // -- CRUD --
    // CREATE
    // Método para cadastrar Endereço
    public Endereco cadastrarEndereco(Endereco endereco){
        enderecoRepository.save(endereco);
        return endereco;
    }

    // READ 
    // Método para listar todas as entregas
    public List<Endereco> listarTodos(){
        return enderecoRepository.findAll();
    }

    // Método para buscar por id
    public Endereco buscarPorId(Integer id){
        Optional<Endereco> enderecoBuscado = enderecoRepository.findById(id);
        return enderecoBuscado.orElse(null);
    }

    // UPDATE
    // Método para atualizar endereco
    public Endereco atualizarEndereco(Integer id, Endereco endereco){
        Endereco enderecoExistente = buscarPorId(id);
        if(enderecoExistente == null){
            return null;
        }

        enderecoExistente.setCep(endereco.getCep());
        enderecoExistente.setCidade(endereco.getCidade());
        enderecoExistente.setLogradouro(endereco.getLogradouro());
        enderecoExistente.setNumero(endereco.getNumero());
        enderecoExistente.setUsuario(endereco.getUsuario());

        return enderecoRepository.save(enderecoExistente);
    }
    
}
