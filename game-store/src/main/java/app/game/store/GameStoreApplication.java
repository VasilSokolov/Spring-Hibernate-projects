package app.game.store;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import app.game.store.config.ModelMapperConfig;
//import repository.builder.lib.ANSRBuilder;
//import repository.builder.lib.enums.interfaces.Strategy;

@SpringBootApplication
@PropertySource(value = {"classpath:app.properties", "classpath:local.properties"})
public class GameStoreApplication {

	public static void main(String[] args) {
//		ANSRBuilder.run(Strategy.REPOSITORIES_AND_SERVICES(), GameStoreApplication.class, args);
		SpringApplication.run(GameStoreApplication.class, args);
	}
	
	@Bean
	public ModelMapper getMapper() {
		ModelMapper modelMapper = new ModelMapper();
		ModelMapperConfig config = new ModelMapperConfig(modelMapper);
		return modelMapper;
	}
}
