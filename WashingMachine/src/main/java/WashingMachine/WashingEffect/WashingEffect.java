package WashingMachine.WashingEffect;

import Utils.MSG;
import WashingMachine.Components.Drum;
import WashingMachine.Components.WaterTempSensor;
import WashingMachine.WashingMachine;
import WashingMachine.WashingMachineModes;

import java.util.stream.IntStream;

/**
 * The WashingEffect class provides methods for starting and managing a wash cycle in a washing machine.
 * <p>
 * Properties:
 * <p>
 * - washingMachine:
 * A reference to the WashingMachine instance that this class operates on.
 * <p>
 * Constructor:
 * - The constructor initializes the washingMachine property and starts a wash cycle with the given mode.
 * <p>
 * Methods:
 * <p>
 * - start:
 * A static method that creates a new WashingEffect instance and starts a wash cycle with the given mode.
 * <p>
 * - startMode:
 * Starts a wash cycle with the given mode. It sets the water temperature and spinning speed, and performs a pre-wash, main wash, and an extra rinse if needed.
 * <p>
 * - endMode:
 * Ends a wash cycle. It resets the water temperature and spinning speed to 0.
 * <p>
 * - preWash:
 * Performs a pre-wash for the given amount of time.
 * <p>
 * - mainWash:
 * Performs a main wash for the given amount of time.
 * <p>
 * - extraRinse:
 * Performs an extra rinse for the given amount of time.
 * <p>
 *
 * @see WashingMachine
 * @see WashingMachineModes
 */
public class WashingEffect {

    private final WashingMachine washingMachine;


    public WashingEffect(WashingMachineModes mode) {
        washingMachine = WashingMachine.getInstance();
        startMode(mode);
        endMode();
    }

    public void startMode(WashingMachineModes mode) {

        washingMachine.getComponent(WaterTempSensor.class).setWaterTemperature(mode.getWaterTemperature());
        washingMachine.getComponent(Drum.class).setSpinningSpeed(mode.getSpinningSpeed());

        preWash(mode.getPreWashTime());
        mainWash(mode.getMainWashTime());


    }

    public void endMode() {
        washingMachine.getComponent(WaterTempSensor.class).setWaterTemperature(0);
        washingMachine.getComponent(Drum.class).setSpinningSpeed(0);
    }


    private void printUpdateAndPause(int i) {
        try {
            MSG.print(STR."Washing... \{i + 1} second(s) passed");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            MSG.print("preWash failed!");
            MSG.print(e.getMessage());
        }
    }

    public void performWash(String startMessage, String endMessage, int washTime) {
        MSG.print(startMessage);
        IntStream.range(0, washTime).forEach(this::printUpdateAndPause);
        MSG.print(endMessage);
    }

    public void preWash(int preWashTime) {
        performWash("pre Wash started...", "pre Wash ended.", preWashTime);
    }

    public void mainWash(int mainWashTime) {
        performWash("main Wash started...", "main Wash ended.", mainWashTime);
    }

    public void extraRinse(int extraRinseTime) {
        performWash("extra Rinse started...", "extra Rinse ended.", extraRinseTime);
    }
}