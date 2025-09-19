package br.com.senai.Entregas.validation;

import br.com.senai.Entregas.validation.validationConstraints.PlacaCarro;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// ConstraintValidator válida uma constraint, ou seja uma regra
// Com ela nós criamos uma regra personalizada

public class PlacaDeCarroValidation implements ConstraintValidator<PlacaCarro, String> {

    @Override
    public void initialize(PlacaCarro constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    // Esse método irá dizer se um campo é válido ou não
    // aqui nós criamos a regra da validação
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        String placa = value == null ? "" : value;
        // Regra para uma placa válida:
        return placa.matches("[a-zA-Z]{3}[0-9][A-Za-z0-9][0-9]{2}");
    }
}
