package db_advanced.ingredients.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "production_batch")
public class ProductionBatch {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "productionBatch", targetEntity = BasicShampoo.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BasicShampoo> basicShampoos = new HashSet<BasicShampoo>();

    public ProductionBatch() {
    }

    public ProductionBatch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Set<BasicShampoo> getBasicShampoos() {
        return basicShampoos;
    }

    public void setBasicShampoos(Set<BasicShampoo> basicShampoos) {
        this.basicShampoos = basicShampoos;
    }

}
