package app.game.store;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Validation;
import javax.validation.Validator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.game.store.model.dto.json.GameDto;
import app.game.store.model.dto.json.serialize.Serializer;
import app.game.store.model.entity.Game;
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
	
	private static final String GAME_INPUT_JSON = "/input/json/game.json";
	private static final String GAME_OUTPUT_JSON = "src/main/resources/output/json/game.json";
	
	@Autowired
	@Qualifier(value = "JsonSerializer")
	private Serializer serializer;
	
	@Autowired
	@Qualifier(value = "XMLMarshalling")
	private Serializer marshalling;
	
	
	@Autowired
	public CmdRunner(GameService gameService, UserService userService, RoleService roleService) {
		this.gameService = gameService;
		this.userService = userService;
		this.roleService = roleService;
		this.authenticatedUser = new HashMap<Long, User>();
	}

	@Override
	public void run(String... args) throws Exception {
//		this.gameService.test();
		importGameJson();
	}
	
	private void gameDto(GameDto gameDto) {
		ModelMapper mapper = new ModelMapper();
		Game game = mapper.map(gameDto, Game.class);
		
		gameService.create(game);
		
//		GameDto gameDto1 = mapper.map(game, GameDto.class);
		
//		System.out.println("Print Game: " + game.toString());
//		System.out.println("Print GameDto1: " + gameDto1.toString());
	}
	
	public void importGameJson() throws ParseException {
		GameDto gameDto = serializer.deserialize(GameDto.class, GAME_INPUT_JSON);
		if (gameDto != null) {
			gameDto(gameDto);
		}
	}
	
	
	
	Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

}
