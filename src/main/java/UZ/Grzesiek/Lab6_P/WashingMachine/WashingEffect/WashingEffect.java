package UZ.Grzesiek.Lab6_P.WashingMachine.WashingEffect;

import UZ.Grzesiek.Lab6_P.Utils.MSG;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachine;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachineModes;
import java.util.stream.IntStream;

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
        washingMachine.setWaterTemperature(mode.getWaterTemperature());
        washingMachine.setSpinningSpeed(mode.getSpinningSpeed());
        preWash(mode.getPreWashTime());
        mainWash(mode.getMainWashTime());
        if(mode.isExtraRinse()){
            extraRinse(WashingMachineModes.extraRinseTime);
        }
    }

    public void endMode() {
        washingMachine.setWaterTemperature(0);
        washingMachine.setSpinningSpeed(0);
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