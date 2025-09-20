package br.com.senai.Entregas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// Anotações
// Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// JPA
@Entity // Informa que essa classe é uma tabela
@Table(name="usuario")
public class Usuario implements UserDetails {

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
    // Avisar para o java, qual coluna da tabela tipu_usuário vou relacionar
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;


    @Override
    @JsonIgnore
    // Define os cargos do funcionario
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(tipoUsuario.getDescricao()));
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return senha;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }



    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
