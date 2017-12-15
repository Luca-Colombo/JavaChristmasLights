import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Main class
 *
 * @author Colombo Luca
 */
public class Xmas {

    // The resolution at which the song is played
    private final static int resolution = 100;

    public static void main(String[] args) {
        Lights lights = new Lights();
        Music music = new Music();
        List<Line> sequence;
        long startTime;
        long currentTime;


        try {
            sequence = CsvParser.parseType();

            startTime = System.currentTimeMillis();

            lights.speakerCh(); // Turn on the channel with the speaker

            //TODO add path
            music.play("diocibenedira.wav");

            for (Line line : sequence) {

                currentTime = System.currentTimeMillis() - startTime;

                if (line.getTime() <= currentTime) {

                    System.out.print(line.getTime() + "   ");
                    for (int ch = 0; ch <6; ch++) {
                        if (line.getChannels()[ch] == 255) {
                            lights.setHigh(ch);
                        } else {
                            lights.setLow(ch);

                        }
                        System.out.print(line.getChannels()[ch] + "   ");
                    }
                    System.out.println();
                }
                sleep(resolution);
            }

            lights.shutdown();



        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
