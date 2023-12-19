package Lab6_P.WashingMachine.WashingEffect;

import Lab6_P.Utils.MSG;
import Lab6_P.WashingMachine.Components.Drum;
import Lab6_P.WashingMachine.Components.WaterTempSensor;
import Lab6_P.WashingMachine.WashingMachine;
import Lab6_P.WashingMachine.WashingMachineModes;

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

    public static void start(WashingMachineModes mode) {
        new WashingEffect(mode);
    }

    private WashingEffect(WashingMachineModes mode) {
        washingMachine = WashingMachine.getInstance();
        startMode(mode);
        endMode();
    }

    public void startMode(WashingMachineModes mode) {
        washingMachine.getComponent(WaterTempSensor.class).setWaterTemperature(mode.getWaterTemperature());
        washingMachine.getComponent(Drum.class).setSpinningSpeed(mode.getSpinningSpeed());
        preWash(mode.getPreWashTime());
        mainWash(mode.getMainWashTime());
        if (mode.isExtraRinse()) {
            extraRinse(WashingMachineModes.extraRinseTime);
        }
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

    public void preWash(int preWashTime) {
        MSG.print("pre Wash started...");
        IntStream.range(0, preWashTime).forEach(this::printUpdateAndPause);
        MSG.print("pre Wash ended.");
    }

    public void mainWash(int mainWashTime) {
        MSG.print("main Wash started...");
        IntStream.range(0, mainWashTime).forEach(this::printUpdateAndPause);
        MSG.print("main Wash ended.");
    }

    public void extraRinse(int extraRinseTime) {
        MSG.print("extra Rinse started...");
        IntStream.range(0, extraRinseTime).forEach(this::printUpdateAndPause);
        MSG.print("extra Rinse ended.");
    }
}