package br.com.senai.Entregas.dtos;


import lombok.Data;

@Data
// nós armazenamos o login apenas para realizar a verificação do usuário
// esses dados não vão para o banco
public class LoginRequest {
    private String email;
    private String senha;

}
