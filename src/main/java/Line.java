import com.opencsv.bean.CsvBindByPosition;

/**
 * This class is used to tell the CsvParser.class how are composed the data line imported.
 *
 * @author Colombo Luca
 */
public class Line {

    @CsvBindByPosition(position = 0)
    private int time;

    @CsvBindByPosition(position = 1)
    private int ch1;

    @CsvBindByPosition(position = 2)
    private int ch2;

    @CsvBindByPosition(position = 3)
    private int ch3;

    @CsvBindByPosition(position = 4)
    private int ch4;

    @CsvBindByPosition(position = 5)
    private int ch5;

    @CsvBindByPosition(position = 6)
    private int ch6;

    private int[] channels = new int[6];

    public int getTime() {
        return time;
    }

    public int getCh1() {
        return ch1;
    }

    public int getCh2() {
        return ch2;
    }

    public int getCh3() {
        return ch3;
    }

    public int getCh4() {
        return ch4;
    }

    public int getCh5() {
        return ch5;
    }

    public int getCh6() {
        return ch6;
    }

    private void setChannels() {
        channels[0] = ch1;
        channels[1] = ch2;
        channels[2] = ch3;
        channels[3] = ch4;
        channels[4] = ch5;
        channels[5] = ch6;
        //channels[0] = ch7;
        //channels[0] = ch8;

    }

    public int[] getChannels() {
        setChannels();
        return channels;
    }
    // UNCOMMENT ONLY IF 8 CHANNELS ARE USED
    /*
    @CsvBindByPosition(position = 7)
    private int ch7;
    @CsvBindByPosition(position = 8)
    private int ch8;

    public int getCh7() {
        return ch7;
    }

    public int getCh8() {
        return ch8;
    }
    */

}
