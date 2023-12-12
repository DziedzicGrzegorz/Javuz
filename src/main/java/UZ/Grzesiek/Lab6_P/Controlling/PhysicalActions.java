package UZ.Grzesiek.Lab6_P.Controlling;


import UZ.Grzesiek.Lab6_P.StatusOfMachine.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.Utils.MSG;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachine;
import lombok.Getter;

@Getter
public class PhysicalActions implements PhysicalInterface{

    protected final WashingMachine washingMachine;


    public PhysicalActions() {
        this.washingMachine = WashingMachine.getInstance();
    }

    @Override
    public StatusOfMachine pumpInWater(int levelOfWater) {
        if (PermissionValues.WATER_ON_DRUM.isValueInRange(levelOfWater)) {
            MSG.print(STR."\{levelOfWater} is out of allowed Range");
            return StatusOfMachine.ERROR;
        }
        try {
            MSG.print("Pumping water...");
            Thread.sleep(1000);

            washingMachine.setLevelOfWater(levelOfWater);

            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Pumping water in failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }

    @Override
    public StatusOfMachine pumpOutWater() {

        try {
            MSG.print("Pumping water out...");
            Thread.sleep(1000);

            washingMachine.setLevelOfWater(0);

            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Pumping water out  failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }

    @Override
    public StatusOfMachine heatWater(int tempToAssign) {
        if (PermissionValues.TEMP_OF_WATER.isValueInRange(tempToAssign)) {
            MSG.print(STR."\{tempToAssign} is out of allowed Range");
            return StatusOfMachine.ERROR;
        }

        try{
            MSG.print("Heating water...");
            Thread.sleep(1000);

            MSG.print(STR."Water heated to \{tempToAssign} degrees Celsius.");

            washingMachine.setWaterTemperature(tempToAssign);

            return StatusOfMachine.OK;

        } catch (Exception e) {
            MSG.print("Heating water failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }

    @Override
    public StatusOfMachine balanceDrumContents() {
        MSG.print("Balancing drum contents...");
        try {
            Thread.sleep(1000);
            MSG.print("Drum contents balanced.");
            washingMachine.drum.Balancing();
            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Balancing drum contents failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }

    @Override
    public StatusOfMachine addFabricSoftener(int amountOfSoftener) {
        if(PermissionValues.DETERGENT_CONTAINER_FABRIC_SOFTENER.isValueInRange(amountOfSoftener)){
            MSG.print("");
        }

        MSG.print("Adding fabric softener...");
        try {
            Thread.sleep(1000);
            MSG.print("Fabric softener added.");
            washingMachine.detergentContainer.setFabricSoftenerLevel(amountOfSoftener);

            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Adding fabric softener failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }

    @Override
    public StatusOfMachine addLaundryDetergent(int amountOfDetergent) {
        if(PermissionValues.DETERGENT_CONTAINER_LAUNDRY.isValueInRange(amountOfDetergent)){
            MSG.print(STR."\{amountOfDetergent} is out of allowed Range");
        }

        MSG.print("Adding Laundry softener...");
        try {
            Thread.sleep(1000);
            MSG.print("Laundry added.");
            washingMachine.detergentContainer.setLaundryDetergentLevel(amountOfDetergent);

            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Adding Laundry failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }
}
