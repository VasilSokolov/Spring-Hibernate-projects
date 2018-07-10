package app.products.shop.services.user;

import app.products.shop.model.dto.binding.user.UserCreateBindingModel;
import app.products.shop.model.entity.User;
import app.products.shop.repositories.UserRepository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.reflect.TypeToken;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository,
							ModelMapper modelMapper) { 
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void save(UserCreateBindingModel model) {
		User user = modelMapper.map(model, User.class);
		this.userRepository.saveAndFlush(user);
	}

	@Override
	public void saveAll(Collection<UserCreateBindingModel> models) {
		Type listType = new TypeToken<ArrayList<User>>() {}.getType();
		Collection<User> users = this.modelMapper.map(models, listType);
		this.userRepository.saveAll(users);
	}

	@Override
	public User user() {
		return this.userRepository.getOne(2);
	}

}