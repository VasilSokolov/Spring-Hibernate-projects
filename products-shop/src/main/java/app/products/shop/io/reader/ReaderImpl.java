package app.products.shop.io.reader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

@Component
public class ReaderImpl implements Reader {

	@Override
	public List<String> readAllLines(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readLines(String fileName) {
		InputStream inputStream = Reader.class.getResourceAsStream(fileName);
		try {
			return StreamUtils.copyToString(inputStream, Charset.defaultCharset());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		InputStream inputStream = Reader.class.getResourceAsStream(fileName);
//		StringBuilder sb = new StringBuilder();		
//		String line = "";
//		try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
//			while ((line = reader.readLine()) != null) {
//				sb.append(line);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return sb.toString();
	}

}
