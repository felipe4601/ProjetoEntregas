package br.com.senai.Entregas.exception;

import org.springframework.data.repository.query.Param;

public class UserNotFoundException extends RuntimeException{

    // Mensagem padrão
    public UserNotFoundException(){
        super("Usuário não encontrado!");
    }
    // Passamos como parâmetro uma mensagem personalizada
    public UserNotFoundException(String message){
        super(message + " não encontrado!");
    }
}
