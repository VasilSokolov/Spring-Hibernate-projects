package app.game.store.model.dto.json.serialize;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component(value = "JsonSerializer")
public class JsonSerializer implements Serializer {

	private Gson gson;

	public JsonSerializer(Gson gson) {
		this.gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()
				.setPrettyPrinting()
				// .registerTypeAdapter(Date.class, new DateDeserializer())
				// .setDateFormat("yyyy-MM-dd")
				.create();

//		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	}

	@Override
	public <S> S deserialize(Class<S> clazz, String fileName) throws ParseException {
//		String birthday = "22-03-2016";
//		Date birthdayDate = new SimpleDateFormat("dd-MM-yyyy", Locale.UK).parse(birthday);
		String json ="{\r\n" + 
				"	\"id\": 1,\r\n" + 
				"	\"title\": \"Tittle\",\r\n" + 
				"	\"youtubeId\": \"www.youtube.com\",\r\n" + 
				"	\"imageUrl\": \"www.image.org\",\r\n" + 
				"	\"size\": 20.5,\r\n" + 
				"	\"price\": 5000.25,\r\n" + 
				"	\"description\": \"Description text\",\r\n" + 
//				"	\"releaseDate\":" + birthday + ",\r\n" + 
				"	\"users\": [\r\n" + 
				"		{\r\n" + 
				"			\"email\": \"www.abv.bg\",\r\n" + 
				"			\"password\": \"Ivan1\",\r\n" + 
				"			\"fullName\": \"Ivan\"\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"email\": \"www.abv1.bg\",\r\n" + 
				"			\"password\": \"Ivan2\",\r\n" + 
				"			\"fullName\": \"Ivancho\"\r\n" + 
				"		}\r\n" + 
				"	]\r\n" + 
				"}";
		return gson.fromJson(json, clazz);
	}

}
