package UZ.Grzesiek.Lab6_P.Controlling;

import UZ.Grzesiek.Lab6_P.MSG;
import UZ.Grzesiek.Lab6_P.PermissionValues;
import UZ.Grzesiek.Lab6_P.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.WashingMachine;
public class PhysicalActions implements PhysicalInterface{

    protected final WashingMachine washingMachine;

    public PhysicalActions(WashingMachine washingMachine) {
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
        return null;
    }

    @Override
    public StatusOfMachine checkFilter(){
        try{
            MSG.print("Checking filter...");
            Thread.sleep(1000);
            WashingMachine.WaterFilterStatus waterFilterStatus =  washingMachine.getWaterFilterStatus();
            if(waterFilterStatus == WashingMachine.WaterFilterStatus.OK) {
                MSG.print("Filter is OK.");
                return StatusOfMachine.OK;
            }

        }catch (Exception e){
            MSG.print("Checking filter failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }


        return null;
    }

    public WashingMachine getWashingMachine() {
        return washingMachine;
    }
}
