
interface SmartDevice {

    void turnOn();

    void turnOff();

    void adjustSettings();
}

class SmartTv implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("Turning ON Smart TV.");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning OFF Smart TV.");
    }

    @Override
    public void adjustSettings() {
        System.out.println("Adjusting Smart TV Settings.");
    }
}

class Lights implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("Turning ON lights.");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning OFF lights.");
    }

    @Override
    public void adjustSettings() {
        System.out.println("Adjusting lights settings.");
    }

}

abstract class SmartDeviceController {

    protected SmartDevice smartDevice;

    public SmartDeviceController(SmartDevice smartDevice) {
        this.smartDevice = smartDevice;
    }

    public abstract void turnOn();

    public abstract void turnOff();

    public abstract void adjustSettings();
}

class PhilipsController extends SmartDeviceController {

    public PhilipsController(SmartDevice smartDevice) {
        super(smartDevice);
    }

    @Override
    public void turnOn() {
        System.out.println("Philips Controller:");
        smartDevice.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Philips Controller:");
        smartDevice.turnOff();
    }

    @Override
    public void adjustSettings() {
        System.out.println("Philips Controller:");
        smartDevice.adjustSettings();
    }
}

class LGController extends SmartDeviceController {

    public LGController(SmartDevice smartDevice) {
        super(smartDevice);
    }

    @Override
    public void turnOn() {
        System.out.println("LG Controller:");
        smartDevice.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("LG Controller:");
        smartDevice.turnOff();
    }

    @Override
    public void adjustSettings() {
        System.out.println("LG Controller:");
        smartDevice.adjustSettings();
    }
}

public class Solution {

    public static void main(String[] args) {
        // Philips Lights
        SmartDeviceController philipsLights = new PhilipsController(new Lights());
        philipsLights.turnOn();
        philipsLights.adjustSettings();
        philipsLights.turnOff();

        // LG Smart TV
        SmartDeviceController lgTv = new LGController(new SmartTv());
        lgTv.turnOn();
        lgTv.adjustSettings();
        lgTv.turnOff();
    }
}
