package br.com.senai.Entregas.model;


import br.com.senai.Entregas.validation.validationConstraints.PlacaCarro;
import ch.qos.logback.classic.spi.LoggingEventVO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @OnDelete(action= OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @NotNull
    @Column(name = "placa", nullable=false, columnDefinition="TEXT", unique = true)
    @PlacaCarro(message = "Campo inválido")
    private String placa;
    // Obriga que o campo seja preenchido e não tenha espaços em branco
    @NotNull
    @NotBlank(message = "Campo não informado")
    @Column(name = "modelo", nullable=false, columnDefinition="TEXT")
    private String modelo;

    @NotNull
    @NotBlank(message = "Campo não informado")
    @Column(name = "tipo", nullable=false, columnDefinition="TEXT")
    private String tipo;


}
