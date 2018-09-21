package app.products.shop.io.reader;

import java.util.List;

public interface Reader {

    List<String> readAllLines(String fileName);

    String readLines(String fileName);
}
