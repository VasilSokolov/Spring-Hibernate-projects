package app.game.store.config;

import org.modelmapper.ModelMapper;

public class ModelMapperConfig {

	private final ModelMapper modelMapper;

	public ModelMapperConfig(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	private void initialize() {
		
	}
}
