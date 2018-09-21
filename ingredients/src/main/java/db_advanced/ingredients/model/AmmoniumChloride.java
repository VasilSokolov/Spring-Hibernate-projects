package db_advanced.ingredients.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "AmmonChl")
public class AmmoniumChloride extends ChemicalIngredient {

    public AmmoniumChloride() {
        super("Ammonium Chlorid", BigDecimal.valueOf(5.12), "NH4Cl");
    }
}
