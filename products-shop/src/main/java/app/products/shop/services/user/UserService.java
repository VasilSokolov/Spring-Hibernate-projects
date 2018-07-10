package app.products.shop.services.user;

import java.util.Collection;

import app.products.shop.model.dto.binding.user.UserCreateBindingModel;
import app.products.shop.model.entity.User;

public interface UserService {
	
	void save(UserCreateBindingModel users);
	void saveAll(Collection<UserCreateBindingModel> models);
	User user();
	
}