import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Colombo Luca
 */


public class Music {
    static AudioInputStream audioStream;
    static File audioFile;
    static Clip clip;


    private static void openFile (String path) {

        audioFile = new File(path); //TODO insert pathname

    }

    private static void loadSong(String path) {

        try {

            openFile(path);
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void play(String path){
        loadSong(path);
        clip.start();

    }

}
