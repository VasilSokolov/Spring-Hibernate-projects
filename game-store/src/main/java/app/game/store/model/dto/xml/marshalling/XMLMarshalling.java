package app.game.store.model.dto.xml.marshalling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import app.game.store.model.dto.json.serialize.Serializer;

@Component(value = "XMLMarshalling")
public class XMLMarshalling implements Serializer {

	private static final String USER_INPUT_DIRECTORY = "/src/main/java/app/game/store/resources/input/xml";
	private static final String USER_OUTPUT_DIRECTORY = "/src/main/java/app/game/store/resources/output/xml";
	
	public <T> T importFromFile(Class<T> classObj, String fileName) {
		
		String path = System.getProperty("user.dir") + USER_INPUT_DIRECTORY + fileName;
		try {
			File file = new File(path);			
			JAXBContext context = JAXBContext.newInstance(classObj);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			T importFromFile = (T) unmarshaller.unmarshal(file);
			return importFromFile;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public <T> void exportToFile(T t, String fileName) {		

		String path = System.getProperty("user.dir") + USER_OUTPUT_DIRECTORY + fileName;
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(t.getClass());

			Marshaller marshaller = context.createMarshaller();
//			FileWriter writer = new FileWriter(path);
//			marshaller.marshal(context, writer);
			FileOutputStream outputStream = new FileOutputStream(path);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(context, outputStream);
			
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public <S> S deserialize(Class<S> clazz, String fileName) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

}
