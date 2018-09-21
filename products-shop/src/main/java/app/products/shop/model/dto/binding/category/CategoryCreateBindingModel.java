package app.products.shop.model.dto.binding.category;

import java.io.Serializable;

public class CategoryCreateBindingModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public CategoryCreateBindingModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
