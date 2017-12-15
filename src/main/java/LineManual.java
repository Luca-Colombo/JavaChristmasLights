import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author Colombo Luca
 */
public class LineManual {

    @CsvBindByPosition(position = 0)
    private int time;

    @CsvBindByPosition(position = 1)
    private int channel;

    @CsvBindByPosition(position = 2)
    private int state;

    public int getTime() {
        return time;
    }

    public int getChannel() {
        return channel;
    }

    public int getState() {
        return state;
    }
}
