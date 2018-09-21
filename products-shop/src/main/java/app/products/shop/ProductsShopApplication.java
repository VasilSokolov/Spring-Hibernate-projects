package app.products.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

//import repository.builder.lib.ANSRBuilder;
//import repository.builder.lib.enums.interfaces.Strategy;

@SpringBootApplication
@PropertySource(value = {"classpath:app.properties", "classpath:local.properties"})
public class ProductsShopApplication {

    public static void main(String[] args) {
//		ANSRBuilder.run(Strategy.REPOSITORIES_AND_SERVICES(), ProductsShopApplication.class, args);
        SpringApplication.run(ProductsShopApplication.class, args);
    }
}
