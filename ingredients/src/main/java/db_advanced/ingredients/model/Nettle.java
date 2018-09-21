package db_advanced.ingredients.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Nettle")
public class Nettle extends BasicIngredient {

    public Nettle() {
        super("Nettle", BigDecimal.valueOf(4.23));
        // TODO Auto-generated constructor stub
    }


}
