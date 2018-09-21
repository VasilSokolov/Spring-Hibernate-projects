package db_advanced.ingredients.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Mint")
public class Mint extends BasicIngredient {

    public Mint() {
        super("Mint", BigDecimal.valueOf(2.34));
    }
}
