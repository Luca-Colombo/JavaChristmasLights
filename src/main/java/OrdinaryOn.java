/**
 * Class that sets the lights on. Used everyday.
 *
 * @author Colombo Luca
 */
public class OrdinaryOn implements Runnable{

    private volatile boolean isRunning = true;

    private Lights lights = new Lights();

    public void stopRunning(){
        isRunning = false;
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
        try {
            while (isRunning){
                // Set every light on and wait 60 seconds.
                for (int i = 0; i < 6; i++) {
                    lights.setHigh(i);
                }
                Thread.sleep(60000);
                // Repeat the 'chasing effect' for 5 times.
                for (int i = 0; i < 5; i++) {
                    // Every 0.1 sec turn on the following light and turn off the previous one.
                    for (int j = 0; j < 5; j++) {
                        lights.setHigh(j);
                        if (j == 0) {
                            lights.setLow(4);
                        } else {
                            lights.setLow(j-1);
                        }
                        Thread.sleep(100);
                    }

                }
            }

            lights.shutdown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
