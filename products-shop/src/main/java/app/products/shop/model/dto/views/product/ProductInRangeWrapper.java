package app.products.shop.model.dto.views.product;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
//@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInRangeWrapper implements Serializable {

    @XmlElement(name = "product")
    private List<ProductInRangeViewModel> products;

    public List<ProductInRangeViewModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInRangeViewModel> products) {
        this.products = products;
    }
}
