package app.products.shop.services.product;

import java.util.Collection;

import app.products.shop.model.dto.binding.product.ProductCreateBindingModel;

public interface ProductService {
	
	void saveAll(Collection<ProductCreateBindingModel> model);
}