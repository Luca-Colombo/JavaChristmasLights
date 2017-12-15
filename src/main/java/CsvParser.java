import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
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
    public static List<Line> parseFromVixen(String file) throws IOException {

        File f = new File(file).getAbsoluteFile();

        List<Line> beans = new CsvToBeanBuilder(new FileReader(f))
                .withType(Line.class).build().parse();

        return beans;
    }

    public static List<LineManual> parseFromManual(String file) throws IOException {

        File f = new File(file).getAbsoluteFile();

        List<LineManual> beans = new CsvToBeanBuilder(new FileReader(f))
                .withType(LineManual.class).build().parse();

        return beans;
    }


}
