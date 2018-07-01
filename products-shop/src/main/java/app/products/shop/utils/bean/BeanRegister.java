package app.products.shop.utils.bean;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.products.shop.utils.config.ModelMapperConfig;

@Configuration
public class BeanRegister {

	private final ResourceLoader resourceLoader;
	
	@Autowired
	public BeanRegister(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}



	@Bean
	public Gson getGson() {
		
		return new GsonBuilder()
				.setPrettyPrinting()
				.create();
		
//		return new GsonBuilder()
//				.excludeFieldsWithoutExposeAnnotation()
//				.setPrettyPrinting()
//				.create();
	}
	
	@Bean
	public ModelMapper getMapper () {
		return new ModelMapper();
	}
}
