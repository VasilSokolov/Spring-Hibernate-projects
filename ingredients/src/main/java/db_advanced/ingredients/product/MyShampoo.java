package db_advanced.ingredients.product;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="MyShampoo")
public class MyShampoo extends BasicShampoo {

	private static final String NAME = "My Shampoo";
	private static final BigDecimal PRICE = BigDecimal.valueOf(5.5);
//	private static final String LABEL = 
			
	public MyShampoo() {
		super(NAME , PRICE);
	}
}
