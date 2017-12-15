import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Class used to parse the sequence files
 *
 * @author Colombo Luca
 */
public class CsvParser {


    /**
     * Parses the CSV file and divides it by line.
     *
     * @return the List containing the values
     * @throws IOException if file is missing
     */
    public static List<Line> parseType() throws IOException {

        List<Line> beans = new CsvToBeanBuilder(new FileReader("diocibenedira.csv"))
                .withType(Line.class).build().parse();

        return beans;
    }

}
