package app.products.shop.model.dto.views.product;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInRangeViewModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlAttribute(name = "price")
	private BigDecimal price;
	
	@XmlAttribute(name = "seller")
	private String seller;	
	
	public ProductInRangeViewModel() {
	}

	public ProductInRangeViewModel(String name, BigDecimal price, String seller) {
		this.name = name;
		this.price = price;
		this.seller = seller;
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "ProductInRangeViewModel [name=" + name + ", price=" + price + ", seller=" + seller + "]";
	}
	
	
}
