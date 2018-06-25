package app.game.store.services.user;

import app.game.store.model.dto.binding.UserRegisterBindingModel;
import app.game.store.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) { 
		this.userRepository = userRepository;
	}

	@Override
	public String register(UserRegisterBindingModel model) {
		// TODO Auto-generated method stub
		return null;
	}

}