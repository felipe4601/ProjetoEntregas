package br.com.senai.Entregas.repository;


import br.com.senai.Entregas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Métodos adicionais
    // Buscar por nome
    Optional<Usuario> findByNomeIgnoreCase(String nome);
    // Buscar pelo nome do veiculo
    List<Usuario> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);
    Optional<Usuario> findByEmail(String email);


}
