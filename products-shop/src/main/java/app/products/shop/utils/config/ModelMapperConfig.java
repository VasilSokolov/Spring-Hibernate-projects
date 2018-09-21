package app.products.shop.utils.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.products.shop.model.dto.binding.product.ProductCreateBindingModel;
import app.products.shop.model.entity.Product;
import app.products.shop.model.entity.User;
import app.products.shop.repositories.UserRepository;

@Component
public class ModelMapperConfig {

    private final ModelMapper modelMapper;
    private UserRepository userRepository;

    public ModelMapperConfig(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.init();
    }

    private void init() {
//		this.productBinding();
        this.poductCreateBindingConfiguration();
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

    private void poductCreateBindingConfiguration() {
        Converter<ProductCreateBindingModel, Product> converter = new AbstractConverter<ProductCreateBindingModel, Product>() {

            @Override
            protected Product convert(ProductCreateBindingModel src) {
                Product product = new Product();
                Integer buyer = src.getBuyer();
                if (buyer != null) {
                    product.setBuyer(userRepository.getOne(buyer));
                }
                product.setSeller(userRepository.getOne(src.getSeller()));
                product.setName(src.getName());
                product.setPrice(src.getPrice());
                return product;
            }
        };
        this.modelMapper.addConverter(converter);
    }
}
