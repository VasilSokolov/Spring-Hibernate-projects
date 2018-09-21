package db_advanced.ingredients.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public abstract class ChemicalIngredient extends BasicIngredient implements ChemicalIngredients {

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    public ChemicalIngredient() {
    }

    public ChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.chemicalFormula = chemicalFormula;
    }

    public String getChemicalFormula() {
        return chemicalFormula;
    }

    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}
