import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Colombo Luca
 */
public class XmasManual implements FactoryXmas {

    Lights lights = new Lights();
    Music music = new Music();
    List<LineManual> sequence;
    long startTime;
    long currentTime;


    @Override
    public void start(String[] args) {
        try {

            sequence = CsvParser.parseFromManual(args[0]);

            startTime = System.currentTimeMillis();

            //lights.speakerCh(); // Turn on the channel with the speaker

            // Create the iterator to iterate through the list of sequences
            ListIterator<LineManual> itr = sequence.listIterator();
            //Get the first line of the sequence
            LineManual line = itr.next();
            // Turn on the speaker
            lights.speakerCh();

            music.play(args[1]);

            System.out.println("music started");

            while (itr.hasNext()) {
                currentTime = System.currentTimeMillis() - startTime;
                // If the current time corresponds to the one on the line sequence
                if(line.getTime() <= currentTime) {
                    // Set the stated channel at the stated state
                    if(line.getState() == 1){
                        lights.setHigh(line.getChannel() - 1);
                    } else {
                        lights.setLow(line.getChannel() - 1);
                    }

                    System.out.println(line.getTime()+"  "+line.getChannel()+"  "+line.getState()+"  "+currentTime);
                    // And proceed to the next line
                    line = itr.next();
                }
            }

            lights.shutdown();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
