package app.products.shop.services.product;

import app.products.shop.model.dto.binding.product.ProductCreateBindingModel;
import app.products.shop.model.dto.views.product.ProductInRangeViewModel;
import app.products.shop.model.entity.Product;
import app.products.shop.repositories.ProductRepository;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.reflect.TypeToken;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) { 
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void saveAll(Collection<ProductCreateBindingModel> models) {
		Type listType = new TypeToken<List<Product>>() {}.getType();
		Collection<Product> products = this.modelMapper.map(models, listType);
		this.productRepository.saveAll(products);
	}

	@Override
	public List<ProductInRangeViewModel> getAllByRangeWithoutBuyer(int from, int to) {
		List<ProductInRangeViewModel> products = this.productRepository.getAllByRangeWithoutBuyer(new BigDecimal(from), new BigDecimal(to));
		return products;
	}

}