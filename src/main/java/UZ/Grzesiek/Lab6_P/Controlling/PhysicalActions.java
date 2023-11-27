package UZ.Grzesiek.Lab6_P.Controlling;

import UZ.Grzesiek.Lab6_P.MSG;
import UZ.Grzesiek.Lab6_P.PermissionValues;
import UZ.Grzesiek.Lab6_P.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.WashingModeSettings;

public class PhysicalActions implements PhysicalInterface{
    private final WashingModeSettings washingMachine;

    public PhysicalActions(WashingModeSettings washingMachine) {
        this.washingMachine = washingMachine;
    }

    @Override
    public StatusOfMachine pumpWater() {
        return null;
    }

    @Override
    public StatusOfMachine heatWater(int tempToAssign) {
        int MAX_TEMP = PermissionValues.TEMP_OF_WATER.getMaxValue();
        int MIN_TEMP = PermissionValues.TEMP_OF_WATER.getMinValue();
        if (tempToAssign < MIN_TEMP && tempToAssign > MAX_TEMP) {
            MSG.print("Temperature is out of range!");
            return StatusOfMachine.ERROR;
        }

        try{
            MSG.print("Heating water...");
            Thread.sleep(1000);

//            washingMachine.setWaterTemperature(tempToAssign);
            MSG.print(STR."Water heated to \{tempToAssign} degrees Celsius.");

            return StatusOfMachine.OK;

        } catch (Exception e) {
            MSG.print("Heating water failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }

    @Override
    public StatusOfMachine balanceDrumContents() {
        return null;
    }

    @Override
    public StatusOfMachine checkFilter() {
        MSG.print("Checking filter...");
        Thread.sleep(1000);
        if (filterIsClean()) {
            MSG.print("Filter is clean.");
            return StatusOfMachine.OK;
        } else {
            MSG.print("Filter is dirty.");
            return StatusOfMachine.SERVICE_NEEDED;
        }
        return null;
    }
}
