import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author Colombo Luca
 */


public class Music implements Runnable{
    static AudioInputStream audioStream;
    static File audioFile;
    static Clip clip;

    private void openFile (String path) {

        audioFile = new File(path); //TODO insert pathname

    }

    public void loadSong(String path) {

        try {

            openFile(path);
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void play(){
        clip.start();
        System.out.println("Canzone partita");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Music());
        t.start();

    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        loadSong("jinglebells.wav");
        play();
        try {
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
