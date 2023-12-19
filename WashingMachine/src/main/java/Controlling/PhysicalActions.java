package Controlling;


import StatusOfMachine.StatusOfMachine;
import Utils.MSG;
import WashingMachine.Components.CheckAbleComponent;
import WashingMachine.Components.DetergentContainer;
import WashingMachine.Components.Drum;
import WashingMachine.Components.WaterTempSensor;
import WashingMachine.PermissionValues;
import WashingMachine.PermissionValuesForModes;
import WashingMachine.WashingMachine;
import lombok.Getter;

/**
 * The PhysicalActions class implements the PhysicalInterface and provides methods for performing physical actions on a washing machine.
 * <p>
 * Properties:
 * - washingMachine: A reference to the WashingMachine instance that this class operates on.
 * <p>
 * Constructor:
 * - The constructor initializes the washingMachine property with the singleton instance of the WashingMachine class.
 * <p>
 * Methods:
 * <p>
 * - pumpWaterIn:
 * Pumps water into the washing machine up to the specified level.
 * If the level is out of the allowed range, it returns an ERROR status.
 * If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - pumpWaterOut:
 * Pumps water out of the washing machine.
 * If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - heatWater:
 * Heats the water in the washing machine to the specified temperature.
 * If the temperature is out of the allowed range, it returns an ERROR status.
 * If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - balanceDrumContents:
 * Balances the contents of the washing machine drum.
 * If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - addFabricSoftener:
 * Adds the specified amount of fabric softener to the washing machine.
 * If the amount is out of the allowed range, it returns an ERROR status.
 * If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - addLaundryDetergent:
 * Adds the specified amount of laundry detergent to the washing machine.
 * If the amount is out of the allowed range, it returns an ERROR status.
 * If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - AfterWashingResetValues:
 * Resets the values of all checkable components of the washing machine after washing.
 * It always returns an OK status.
 * <p>
 *
 * @see WashingMachine
 */
@Getter
public class PhysicalActions {

    protected final WashingMachine washingMachine;

    protected PhysicalActions() {
        this.washingMachine = WashingMachine.getInstance();
    }


    protected StatusOfMachine pumpWater(int levelOfWater) {
        if (PermissionValues.WATER_ON_DRUM.isValueOutOfRange(levelOfWater)) {
            throw new IllegalArgumentException(STR."\{levelOfWater} is out of allowed Range in class \{this.getClass().getSimpleName()}");
        }
        try {
            MSG.print("Pumping water...");
            Thread.sleep(1000);

            washingMachine.getComponent(Drum.class).setLitersOfWater(levelOfWater);

            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Pumping water in failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }


    protected StatusOfMachine heatWater(int tempToAssign) {
        if (PermissionValuesForModes.TEMP_OF_WATER.isValueOutOfRange(tempToAssign)) {
            throw new IllegalArgumentException(STR."\{tempToAssign} is out of allowed Range, probably you you give temp explicitly intead of temp from mode");
        }

        try {
            MSG.print("Heating water...");
            Thread.sleep(1000);

            MSG.print(STR."Water heated to \{tempToAssign} degrees Celsius.");

            washingMachine.getComponent(WaterTempSensor.class).setWaterTemperature(tempToAssign);

            return StatusOfMachine.OK;

        } catch (Exception e) {
            MSG.print("Heating water failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }


    protected StatusOfMachine balanceDrumContents() {
        MSG.print("Balancing drum contents...");
        try {
            Thread.sleep(1000);
            MSG.print("Drum contents balanced.");
            washingMachine.getComponent(Drum.class).Balancing();
            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Balancing drum contents failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }

    protected StatusOfMachine addFabricSoftener(int amountOfSoftener) {
        if (PermissionValues.DETERGENT_CONTAINER_FABRIC_SOFTENER.isValueOutOfRange(amountOfSoftener)) {
            throw new IllegalArgumentException(STR."\{amountOfSoftener} is out of allowed Range to add fabric softener");
        }

        MSG.print("Adding fabric softener...");
        try {
            Thread.sleep(1000);
            MSG.print("Fabric softener added.");
            washingMachine.getComponent(DetergentContainer.class).setFabricSoftenerContainerInMilliliters(amountOfSoftener);

            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Adding fabric softener failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }


    protected StatusOfMachine addLaundryDetergent(int amountOfDetergent) {
        if (PermissionValues.DETERGENT_CONTAINER_LAUNDRY.isValueOutOfRange(amountOfDetergent)) {
            throw new IllegalArgumentException(STR."\{amountOfDetergent} is out of allowed Range to add laundry detergent");
        }

        MSG.print("Adding Laundry softener...");
        try {
            Thread.sleep(1000);
            MSG.print("Laundry added.");

            washingMachine.getComponent(DetergentContainer.class).setLaundryDetergentContainerInMilliliters(amountOfDetergent);

            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Adding Laundry failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }

    protected StatusOfMachine AfterWashingResetValues() {
        // method reference
        washingMachine.getCheckAbleComponents().forEach(CheckAbleComponent::setDefaultValue);
        //lambda expression
//        washingMachine.getCheckAbleComponents().forEach(component -> component.setDefaultValue());
        return StatusOfMachine.OK;
    }
}
