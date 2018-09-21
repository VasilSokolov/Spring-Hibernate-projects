package app.game.store.services.user;

import app.game.store.model.dto.binding.UserRegisterBindingModel;

public interface UserService {

    String register(UserRegisterBindingModel model);
}