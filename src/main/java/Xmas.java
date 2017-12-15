import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 * Main class
 *
 * @author Colombo Luca
 */
public class Xmas {


    public static void main(String[] args) {
        Lights lights = new Lights();
        Music music = new Music();
        List<Line> sequence;
        long startTime;
        long currentTime;


        try {
            sequence = CsvParser.parseType(args[0]);

            System.out.println("Sequence loaded");

            Thread.sleep(3000);

            startTime = System.currentTimeMillis();

            //lights.speakerCh(); // Turn on the channel with the speaker

            // Create the iterator to iterate through the list of sequences
            ListIterator<Line> itr = sequence.listIterator();
            //Get the first line of the sequence
            Line line = itr.next();

            music.play(args[1]);

            System.out.println("music started");


            while (itr.hasNext()) {

                currentTime = System.currentTimeMillis() - startTime;
                // If the current time corresponds to the one on the line sequence
                if (line.getTime() <= currentTime) {
                    // Set the channels
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
                    // And proceed to the next line
                    line = itr.next();
                }
            }

            lights.shutdown();



        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
