package app.game.store.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.springframework.util.ResourceUtils;

public class FileIO {

    public String readJson(String fileName) {

//		String json ="";

        StringBuilder fileContent = new StringBuilder("");

//		InputStream inputStream = getClass().getResourceAsStream(fileName);
//		Resource resource = new ClassPathResource(fileName);
        //Get file from resources folder
//		ClassLoader classLoader = getClass().getClassLoader();
//		File file = new File(classLoader.getResource(fileName).getFile());
        BufferedReader reader = null;
        try {
            File file2w = ResourceUtils.getFile(this.getClass().getResource(fileName));
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            System.out.println(file.getAbsolutePath());

            FileReader fr = new FileReader(fileName);

            reader = new BufferedReader(fr);
            System.out.println("Readerrr  " + reader);
            String line = null;
            while ((line = reader.readLine()) != null) {

                fileContent.append(line);
            }

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
            fnf.getMessage();
            fnf.getCause();
        } catch (Exception e) {
            e.getMessage();
            e.getCause();
        } finally {
            System.out.println("");
//				classLoader.close();
        }

        return fileContent.toString();
    }

    public void writeFile(String fileName, String content) throws FileNotFoundException {

        OutputStream os = new FileOutputStream(fileName);

        try {
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os));
            bfw.write(content);
        } catch (IOException e) {
            e.getMessage();
            e.getCause();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFileJson(String json, String fileName) {

        String path = System.getProperty("user.dir") + File.separator + fileName;

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (OutputStream os = new FileOutputStream(fileName);
             BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os));) {
            bfw.write(json);
            bfw.flush();
        } catch (Exception e) {
            e.getMessage();
            e.getCause();
        }
    }
}
