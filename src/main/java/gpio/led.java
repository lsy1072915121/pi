package gpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class led {


  public static void main(String[] a) throws InterruptedException {

    final GpioController gpioController = GpioFactory.getInstance();

    final GpioPinDigitalOutput pinDigitalOutput = gpioController.provisionDigitalOutputPin(
        RaspiPin.GPIO_01, "LED", PinState.HIGH);
    while (true) {

      pinDigitalOutput.high();
      Thread.sleep(1000);
      pinDigitalOutput.low();
      Thread.sleep(1000);

    }


  }


}
