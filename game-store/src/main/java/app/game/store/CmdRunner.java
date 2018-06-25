package app.game.store;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.game.store.model.entity.User;
import app.game.store.services.game.GameService;
import app.game.store.services.role.RoleService;
import app.game.store.services.user.UserService;


@Component
@Transactional
public class CmdRunner implements CommandLineRunner {

	private final GameService gameService;
	private final UserService userService;
	private final RoleService roleService;
	private final Map<Long, User> authenticatedUser;
	
	@Autowired
	public CmdRunner(GameService gameService, UserService userService, RoleService roleService) {
		this.gameService = gameService;
		this.userService = userService;
		this.roleService = roleService;
		this.authenticatedUser = new HashMap<Long, User>();
	}



	@Override
	public void run(String... args) throws Exception {
		this.gameService.test();
	}

}
