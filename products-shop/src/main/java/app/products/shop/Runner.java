package app.products.shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import app.products.shop.model.dto.binding.product.ProductCreateBindingModel;
import app.products.shop.model.dto.binding.user.UserCreateBindingModel;
import app.products.shop.model.entity.Product;
import app.products.shop.model.entity.User;
import app.products.shop.services.category.CategoryService;
import app.products.shop.services.product.ProductService;
import app.products.shop.services.user.UserService;

@Component
public class Runner implements CommandLineRunner {

	private static final String USER_JSON_FILE_LOCATION = "/inputJson/users.json";
	private static final String PRODUCTS_JSON_FILE_LOCATION = "/inputJson/products.json";
	private static final String CATEGORIES_JSON_FILE_LOCATION = "/inputJson/categories.json";

	private final UserService userService;
	private final ProductService productService;
	private final CategoryService categoryService;

	private final Gson gson;

	@Autowired
	public Runner(UserService userService, ProductService productService, CategoryService categoryService, Gson gson) {
		this.userService = userService;
		this.productService = productService;
		this.categoryService = categoryService;
		this.gson = gson;
	}

	@Override
	public void run(String... args) throws Exception {
//		this.seedUsers();
		this.seedProducts();
	}
	
	private void seedProducts() {
		InputStream inputStream = this.loadData(PRODUCTS_JSON_FILE_LOCATION);
		String loader = readAllData(inputStream);
		Type listType = new TypeToken<ArrayList<ProductCreateBindingModel>>() {}.getType();
		List<ProductCreateBindingModel> products = this.gson.fromJson(loader, listType);
		
		
		products.forEach(this::randomizeData);

		this.productService.saveAll(products);
//		products.stream().peek(p -> this.randomizeData(p));
//		this.showResultFromList(products);
	}
	
	private void randomizeData (ProductCreateBindingModel model) {
		Random random = new Random();
		int buyer = random.nextInt(60);
		if (buyer <= 57) {
			model.setBuyer(buyer);			
		}
		int seller = 0;
		do {

			seller = random.nextInt(57);
			model.setSeller(seller);
		} while (seller == buyer);
	}
	
	private void seedUsers() {
		InputStream inputStream = this.loadData(USER_JSON_FILE_LOCATION);
		String loader = readAllData(inputStream);
		Type listType = new TypeToken<ArrayList<UserCreateBindingModel>>() {}.getType();
		List<UserCreateBindingModel> usersList = this.gson.fromJson(loader, listType);		
		this.userService.saveAll(usersList);
////		for (UserCreateBindingModel user : usersList) {
////			System.out.println(user.toString());
////		}
//		
////		InputStream stream = Runner.class.getResourceAsStream(INPUT_FILE_TO_JSON);
////		StreamUtils.copyToString(stream, Charset.defaultCharset());
//		
////		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
////		reader.lines().forEach(System.out::println);
	}
	
	private void showResultFromList(Collection<Object> list) {
		for (Object t : list) {
		System.out.println(t.toString());
	}
	}
	
	private InputStream loadData(String fileLocation) {
		InputStream stream = Runner.class.getResourceAsStream(fileLocation);
		return stream;
	}
	
	private String readAllData(InputStream stream) {
		try {
			return StreamUtils.copyToString(stream, Charset.defaultCharset());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
