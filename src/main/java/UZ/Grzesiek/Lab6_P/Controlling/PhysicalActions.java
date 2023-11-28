package UZ.Grzesiek.Lab6_P.Controlling;

import UZ.Grzesiek.Lab6_P.Utils.MSG;
import UZ.Grzesiek.Lab6_P.StatusOfMachine.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachine;

public class PhysicalActions implements PhysicalInterface {

    protected final WashingMachine washingMachine;

    public PhysicalActions(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    @Override
    public StatusOfMachine pumpWater() {
try {
            MSG.print("Pumping water...");
            Thread.sleep(1000);
            MSG.print("Water pumped!");
            return StatusOfMachine.OK;

        } catch (Exception e) {
            MSG.print("Pumping water failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }

    }


    @Override
    public StatusOfMachine heatWater(int tempToAssign) {
        int MAX_TEMP = PermissionValues.TEMP_OF_WATER.getMaxValue();
        int MIN_TEMP = PermissionValues.TEMP_OF_WATER.getMinValue();

        if (tempToAssign < MIN_TEMP && tempToAssign > MAX_TEMP) {
            MSG.print("Temperature is out of range!");
            return StatusOfMachine.ERROR;
        }

        try {
            MSG.print("Heating water...");
            Thread.sleep(1000);

//            washingMachine.setWaterTemperature(tempToAssign);
            MSG.print(STR."Water heated to \{tempToAssign} degrees Celsius.");

            washingMachine.setTemperatureOfWater(tempToAssign);

            return StatusOfMachine.OK;

        } catch (Exception e) {
            MSG.print("Heating water failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }

    @Override
    public StatusOfMachine balanceDrumContents() {
        try {
            MSG.print("Balancing drum contents...");
            Thread.sleep(1000);
            MSG.print("Drum contents balanced!");
            return StatusOfMachine.OK;

        } catch (Exception e) {
            MSG.print("Balancing drum contents failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }



    public WashingMachine getWashingMachine() {
        return washingMachine;
    }
}
