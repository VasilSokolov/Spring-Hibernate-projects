package app.products.shop.services.user;

import java.util.Collection;

import app.products.shop.model.dto.binding.user.UserCreateBindingModel;

public interface UserService {
	
	void save(UserCreateBindingModel users);
	void saveAll(Collection<UserCreateBindingModel> models);
	
}