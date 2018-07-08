package app.game.store.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class ValidGame implements ConstraintValidator<GameValidator, String> {

	public void initialize(GameValidator constriant) {
		System.out.println("The game is valid");
	}
	
	public ValidGame() {
		System.out.println("Game created");
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && value.matches("\\d{3}");
	}

}
