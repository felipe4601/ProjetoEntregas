package br.com.senai.Entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

// Anotações Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// JPA
@Entity
@Table(name="entrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_entrega")
    private Integer idEntrega;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_endereco")
    private Endereco endereco;

    @Column(name="descricao_produto", nullable=false, columnDefinition="TEXT")
    private String descricaoProduto;

    @Column(name="status", nullable=false, columnDefinition="TEXT")
    private String status;

    @Column(name="data_pedido", nullable=false)
    private OffsetDateTime dataPedido;
}
