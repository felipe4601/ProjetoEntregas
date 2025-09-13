package br.com.senai.Entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotações
// Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// JPA
@Entity // Informa que essa classe é uma tabela
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_usuario", nullable =false)
    private Integer idUsuario;

    @Column(name="nome", nullable=false, columnDefinition="TEXT")
    private String nome;

    @Column(name="email", nullable=false, columnDefinition="TEXT", unique=true)
    private String email;

    @Column(name="senha", nullable=false, columnDefinition="TEXT")
    private String senha;


    private Integer idTipoUsuario;


}
