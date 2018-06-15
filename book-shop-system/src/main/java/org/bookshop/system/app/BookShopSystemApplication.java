package org.bookshop.system.app;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:app.properties", "classpath:local.properties"})
public class BookShopSystemApplication implements ApplicationRunner{

	private static final Logger log = LogManager.getLogger(BookShopSystemApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookShopSystemApplication.class, args);
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.debug("Debugging log");
		log.info("Info log");
		log.warn("Hey, This is a warning!");
		log.error("Oops! We have an Error. OK");
		log.fatal("Damn! Fatal error. Please fix me.");
        Collection<String> lists = new ArrayList<String>(Arrays.asList("Mint", "Netel"));
        log.info(lists.toString());
	}
}
