package UZ.Grzesiek.Lab6_P.Controlling.PhysicalActions;

import UZ.Grzesiek.Lab6_P.WashingMachine.PermissionValues;
import UZ.Grzesiek.Lab6_P.StatusOfMachine.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.Utils.MSG;
import UZ.Grzesiek.Lab6_P.WashingMachine.Components.CheckAbleComponent;
import UZ.Grzesiek.Lab6_P.WashingMachine.Components.DetergentContainer;
import UZ.Grzesiek.Lab6_P.WashingMachine.Components.Drum;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachine;
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
 * - pumpInWater:
 *   Pumps water into the washing machine up to the specified level.
 *   If the level is out of the allowed range, it returns an ERROR status.
 *   If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - pumpOutWater:
 *   Pumps water out of the washing machine.
 *   If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - heatWater:
 *   Heats the water in the washing machine to the specified temperature.
 *   If the temperature is out of the allowed range, it returns an ERROR status.
 *   If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - balanceDrumContents:
 *   Balances the contents of the washing machine drum.
 *   If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - addFabricSoftener:
 *   Adds the specified amount of fabric softener to the washing machine.
 *   If the amount is out of the allowed range, it returns an ERROR status.
 *   If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - addLaundryDetergent:
 *   Adds the specified amount of laundry detergent to the washing machine.
 *   If the amount is out of the allowed range, it returns an ERROR status.
 *   If an exception occurs during the operation, it prints an error message and returns an ERROR status.
 * <p>
 * - AfterWashingResetValues:
 *   Resets the values of all checkable components of the washing machine after washing.
 *   It always returns an OK status.
 * <p>
 * @see WashingMachine
 * @see PhysicalInterface
 */
@Getter
public class PhysicalActions implements PhysicalInterface {

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

        try {
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
            washingMachine.getComponent(Drum.class).Balancing();
            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Balancing drum contents failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }
    @Override
    public StatusOfMachine addFabricSoftener(int amountOfSoftener) {
        if (PermissionValues.DETERGENT_CONTAINER_FABRIC_SOFTENER.isValueInRange(amountOfSoftener)) {
            MSG.print("");
        }

        MSG.print("Adding fabric softener...");
        try {
            Thread.sleep(1000);
            MSG.print("Fabric softener added.");
            washingMachine.getComponent(DetergentContainer.class).setFabricSoftenerLevel(amountOfSoftener);

            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Adding fabric softener failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }
    @Override
    public StatusOfMachine addLaundryDetergent(int amountOfDetergent) {
        if (PermissionValues.DETERGENT_CONTAINER_LAUNDRY.isValueInRange(amountOfDetergent)) {
            MSG.print(STR."\{amountOfDetergent} is out of allowed Range");
        }

        MSG.print("Adding Laundry softener...");
        try {
            Thread.sleep(1000);
            MSG.print("Laundry added.");
            washingMachine.getComponent(DetergentContainer.class).setLaundryDetergentLevel(amountOfDetergent);

            return StatusOfMachine.OK;
        } catch (Exception e) {
            MSG.print("Adding Laundry failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }
    @Override
    public StatusOfMachine AfterWashingResetValues() {
        washingMachine.getCheckAbleComponents().forEach(CheckAbleComponent::setDefaultValue);
        return StatusOfMachine.OK;
    }
}
