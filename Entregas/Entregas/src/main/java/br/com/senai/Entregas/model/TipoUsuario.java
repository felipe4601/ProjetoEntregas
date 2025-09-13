package br.com.senai.Entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotações
// Lombok
@Getter // Cria os getters
@Setter // Cria os Setters
// Obrigatório para o jpa funcionar
@NoArgsConstructor // Cria o construtor vazio
@AllArgsConstructor // Cria o um construtor com todos os atribútos
// JPA
@Entity // - Informa que essa classe é uma tabela
// Table - Permite que você congigure a tabela
@Table(name = "tipo_usuario")
public class TipoUsuario {
    // Cada coluna é um atribúto da classe
    // Id define que é chave primária
    @Id
    // GeneratedValue - define que a chave é gerenciada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Column - configura a coluna
    @Column(name="id_tipo_usuario", nullable=false)
    // name - nome da coluna
    // nullable - se pode ser nulo ou não
    private Integer idTipoUsuario;
    @Column(name="descricao", nullable=false, columnDefinition = "TEXT")
    private String descricao;
    // Por padrao o jpa cria texto em varchar

}
