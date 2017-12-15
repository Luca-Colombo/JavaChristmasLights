import com.pi4j.io.gpio.*;

/**
 * Class used to control the GPIOs
 *
 * @author Colombo Luca
 */
public class Lights {

    // create gpio controller instance
    final GpioController gpio;

    // setup the array of lights and set them to LOW
    private GpioPinDigitalOutput lights[];



    public Lights() {

        gpio = GpioFactory.getInstance();
        lights = new GpioPinDigitalOutput[]{
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.LOW),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, PinState.LOW),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.HIGH)
        };

        // configure the pins shutdown behavior; these settings will be
        // automatically applied to the pin when the application is terminated
        for (GpioPinDigitalOutput pin : lights) {
            pin.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        }
    }

    /**
     * Set the selected channel light to LOW
     * @param ch the number of the channel to set LOW (1-8)
     */
    public void setLow(int ch) {
        lights[ch].low();
    }

    /**
     * Set the selected channel light to HIGH
     * @param ch the number of the channel to set HIGH (1-8)
     */
    public void setHigh(int ch) {
        lights[ch].high();
    }

    /**
     * Shuts down the Gpios
     */
    public void shutdown() {
        gpio.shutdown();
    }

    public void speakerCh() {
        lights[7].high();
    }
}
