package app.products.shop.utils.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import app.products.shop.model.dto.binding.product.ProductCreateBindingModel;
import app.products.shop.model.entity.Product;
import app.products.shop.model.entity.User;
import app.products.shop.repositories.UserRepository;

public class ModelMapperConfig {

	private final ModelMapper modelMapper;
	private UserRepository userRepository;

	public ModelMapperConfig(ModelMapper modelMapper, UserRepository userRepository) {
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
		this.init();
	}
	
	private void init() {
		this.productBinding();
	}
	
	private void productBinding() {
		this.modelMapper
			.createTypeMap(ProductCreateBindingModel.class, Product.class)
			.addMappings(mapper -> {
				mapper.map(src -> {
					Integer buyer = src.getBuyer();
					if (buyer != null) {
						return this.userRepository.findById(buyer);
					}
					return null;
				}, Product::setBuyer);
				mapper.map(src -> {
					return this.userRepository.findById(src.getSeller());
				}, Product::setSeller);
				mapper.map(ProductCreateBindingModel::getName, Product::setName);
				mapper.map(ProductCreateBindingModel::getPrice, Product::setPrice);
			});
	}
}
