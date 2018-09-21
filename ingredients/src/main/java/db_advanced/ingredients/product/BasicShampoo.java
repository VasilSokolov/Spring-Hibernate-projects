package db_advanced.ingredients.product;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import db_advanced.ingredients.model.BasicIngredient;

@Entity
@Table(name = "shampoos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "basic_shampoo", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicShampoo implements Shampoos {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;

    @Basic
    private BigDecimal price;

    @OneToOne(optional = false)
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    private ClassicLabel label;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    private ProductionBatch productionBatch;

    @ManyToMany
    @JoinTable(name = "shampoo_ingrediants",
            joinColumns = @JoinColumn(name = "shampoo_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediant_id", referencedColumnName = "id"))
    private Set<BasicIngredient> basicIngredients;

    public BasicShampoo(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BasicShampoo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ClassicLabel getLabel() {
        return label;
    }

    public void setLabel(ClassicLabel label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public ProductionBatch getProductionBatch() {
        return productionBatch;
    }

    public void setProductionBatch(ProductionBatch productionBatch) {
        this.productionBatch = productionBatch;
    }

    public Set<BasicIngredient> getBasicIngredients() {
        return basicIngredients;
    }

    public void setBasicIngredients(Set<BasicIngredient> basicIngredients) {
        this.basicIngredients = basicIngredients;
    }


}
