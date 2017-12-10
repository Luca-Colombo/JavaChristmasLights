import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Colombo Luca
 */
public class CsvParser {


    /**
     * Parses the CSV file and divides it by line. Each line is an array of Strings.
     * @return the List containing the arrays with the values
     * @throws IOException if file is missing
     */
    public static List<String[]> parse() throws IOException {

            CSVReader reader = new CSVReader(new FileReader("jinglebells.csv"));
            List<String[]> myEntries = reader.readAll();

            return myEntries;

    }

}
