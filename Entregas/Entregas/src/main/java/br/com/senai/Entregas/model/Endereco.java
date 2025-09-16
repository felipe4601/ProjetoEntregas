package br.com.senai.Entregas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotações lombik
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// JPA
@Entity
@Table(name="endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco", nullable=false)
    private Integer idEndereco;

    // idUsuario
    @ManyToOne(fetch = FetchType.EAGER, optional=false)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "logradouro", nullable=false, columnDefinition="TEXT")
    private String logradouro;

    @Column(name = "numero", nullable=false, columnDefinition="TEXT")
    private String numero;

    @Column(name = "cidade", nullable=false, columnDefinition="TEXT")
    private String cidade;

    @Column(name = "cep", nullable=false, columnDefinition="TEXT")
    private String cep;
}
