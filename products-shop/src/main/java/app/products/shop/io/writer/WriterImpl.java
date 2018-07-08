package app.products.shop.io.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class WriterImpl implements Writer {

	@Override
	public void writeToFile(String source, String fileName) {
		try {
			String mainPath = System.getProperty("user.dir") + "/src/main/resources";
			FileWriter writer = new FileWriter(new File(mainPath + fileName));
			writer.write(source);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
