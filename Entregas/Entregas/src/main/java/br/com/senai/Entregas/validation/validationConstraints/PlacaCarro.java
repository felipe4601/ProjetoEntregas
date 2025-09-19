package br.com.senai.Entregas.validation.validationConstraints;

import br.com.senai.Entregas.validation.PlacaDeCarroValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented // indica que a anotação deve ser incluída na documentação
@Constraint(validatedBy = PlacaDeCarroValidation.class) // determina qual lógica será usada pela anotação
@Target({ ElementType.METHOD, ElementType.FIELD}) // define onde a anotação pode ser aplicada
// podendo ser aplicada em um método, ou diretamente em um campo(variável)
@Retention(RetentionPolicy.RUNTIME)// determina que a anotação estará disponível em tempo de execução
// Aqui nós estamos criando uma anotação de validação personalizada
// Uma forma de criar as minhas próprias regras
public @interface PlacaCarro {
    String message() default "Placa de carro inválida"; // define a mensage de erro se a validação falhar
    Class<?>[] groups() default{}; // Permite agrupar validações, é um padrão da validação
    Class<? extends Payload>[] payload() default {}; // padrão da validação

}
