package app.products.shop.services.category;

import app.products.shop.model.dto.binding.category.CategoryCreateBindingModel;
import app.products.shop.model.entity.Category;
import app.products.shop.model.entity.Product;
import app.products.shop.repositories.CategoryRepository;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.reflect.TypeToken;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) { 
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void saveAll(Collection<CategoryCreateBindingModel> models) {
		Type listType = new TypeToken<List<Category>>() {}.getType();
		Collection<Category> categories = this.modelMapper.map(models, listType);
		this.categoryRepository.saveAll(categories);
		
	}

}