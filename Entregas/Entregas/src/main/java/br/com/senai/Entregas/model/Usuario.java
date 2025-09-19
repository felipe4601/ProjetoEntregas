package br.com.senai.Entregas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @NotBlank
    @Column(name="nome", nullable=false, columnDefinition="TEXT")
    private String nome;

    @Email(message = "Campo inválido")
    @NotBlank(message = "Campo não informado")
    @Column(name="email", nullable=false, columnDefinition="TEXT", unique=true)
    private String email;


    @Column(name="senha", nullable=false, columnDefinition="TEXT")
    private String senha;


    // Mapear relacionamentos
    // Muitos usuários para um tipo usuário
    // FetchType - Carrega os dados juntos
    // optional - Se é obrigatório ou não
    @OnDelete(action= OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    // Avisar para o java, qual coluna da tabela tipu_suário vou relacionar
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;




}
