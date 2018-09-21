package app.game.store.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Pattern(regexp = "\\d{3}")
@Constraint(validatedBy = ValidGame.class)
@Target(value = {})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface GameValidator {

    String message() default "default game ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
