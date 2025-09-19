package br.com.senai.Entregas.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
// Essa classe é usada para fazer o formato do json
public class RestErrorMessage {
    private HttpStatus status;
    private String message;

}
