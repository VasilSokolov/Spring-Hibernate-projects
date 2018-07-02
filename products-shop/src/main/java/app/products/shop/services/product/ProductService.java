package app.products.shop.services.product;

import java.util.Collection;
import java.util.List;

import app.products.shop.model.dto.binding.product.ProductCreateBindingModel;
import app.products.shop.model.dto.views.product.ProductInRangeViewModel;

public interface ProductService {
	
	void saveAll(Collection<ProductCreateBindingModel> model);
	
	List<ProductInRangeViewModel> getAllByRangeWithoutBuyer(int from, int to);
}