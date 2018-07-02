package app.products.shop.services.category;

import java.util.Collection;

import app.products.shop.model.dto.binding.category.CategoryCreateBindingModel;

public interface CategoryService {

	void saveAll(Collection<CategoryCreateBindingModel> model);
}