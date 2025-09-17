package br.com.senai.Entregas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotações Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// JPA

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
    private Integer idVeiculo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "placa", nullable=false, columnDefinition="TEXT", unique = true)
    private String placa;

    @Column(name = "modelo", nullable=false, columnDefinition="TEXT")
    private String modelo;

    @Column(name = "tipo", nullable=false, columnDefinition="TEXT")
    private String tipo;
}
