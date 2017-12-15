import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Class to control the music playback
 *
 * @author Colombo Luca
 */


public class Music {
    private static File audioFile;
    private static Clip clip;


    /**
     * Opens the file containing the music
     * @param path to the music file
     */
    private void openFile (String path) {

        audioFile = new File(path); //TODO insert pathname

    }

    /**
     * Loads the song
     * @param path to te music file
     */
    private void loadSong(String path) {

        try {

            openFile(path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Plays the song after have loaded it
     * @param path to the music file
     */
    public void play(String path){
        loadSong(path);
        clip.start();

    }

}
