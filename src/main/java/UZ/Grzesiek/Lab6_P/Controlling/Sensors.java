package UZ.Grzesiek.Lab6_P.Controlling;

import UZ.Grzesiek.Lab6_P.Utils.MSG;
import UZ.Grzesiek.Lab6_P.StatusOfMachine.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachine;

public class Sensors {
    private final WashingMachine washingMachine;

    Sensors() {
        this.washingMachine = WashingMachine.getInstance();
    }

    public StatusOfMachine PressureOfWater() {
        try {
            MSG.print("Checking pressure of water...");
            Thread.sleep(1000);
            if (washingMachine.get() < 1) {
                MSG.print("Pressure of water is too low!");
                return StatusOfMachine.SERVICE_NEEDED;
            }
            MSG.print("Pressure of water is OK!");
            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Checking pressure of water failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }

    public WashingMachine.WaterFilterStatus checkFilter() {
        try {
            MSG.print("Checking filter...");
            Thread.sleep(1000);
            WashingMachine.WaterFilterStatus waterFilterStatus = washingMachine.getWaterFilterStatus();
            if (waterFilterStatus == WashingMachine.WaterFilterStatus.SERVICE_NEEDED) {
                MSG.print("Filter needs service!");
                return WashingMachine.WaterFilterStatus.SERVICE_NEEDED;
            }
            MSG.print("Filter is OK!");
            return WashingMachine.WaterFilterStatus.OK;

        } catch (Exception e) {
            MSG.print("Checking filter failed!");
            MSG.print(e.getMessage());
            return WashingMachine.WaterFilterStatus.ERROR;
        }
    }
}
