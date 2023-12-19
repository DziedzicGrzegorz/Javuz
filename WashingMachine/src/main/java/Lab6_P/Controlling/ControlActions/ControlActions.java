package Lab6_P.Controlling.ControlActions;


import Lab6_P.Controlling.PhysicalActions.PhysicalActions;
import Lab6_P.Controlling.Sensors.Sensors;
import Lab6_P.StatusOfMachine.StatusOfMachine;
import Lab6_P.Utils.MSG;
import Lab6_P.WashingMachine.PermissionValues;
import Lab6_P.WashingMachine.WashingEffect.WashingEffect;
import Lab6_P.WashingMachine.WashingMachine;
import Lab6_P.WashingMachine.WashingMachineModes;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * This class, ControlActions, extends the PhysicalActions class and implements the ControlInterface.
 * It represents the control actions of a washing machine, including methods to power on/off the machine, start/stop a wash, and reset the machine.
 * <p>
 * Properties:
 * - Inherits all properties from the superclass, look at {@link  PhysicalActions}.
 * <p>
 * Constructor:
 * - The constructor initializes the superclass.
 * <p>
 * Methods:
 * <p>
 * - powerOn:
 * Powers on the washing machine and sets its status to OK.
 * If an exception occurs, it sets the status to ERROR and prints an error message.
 * <p>
 * - powerOff:
 * Powers off the washing machine and sets its status to OFF.
 * If an exception occurs, it sets the status to ERROR and prints an error message.
 * <p>
 * - startWashing:
 * Starts a wash with the given mode and amount of clothes.
 * It checks all components of the washing machine before starting the wash.
 * If an exception occurs, it prints an error message.
 * <p>
 * - stopWashing:
 * Stops the current wash and sets the washing machine's status to STOPPED.
 * If an exception occurs, it sets the status to ERROR and prints an error message.
 * <p>
 * - reset:
 * Resets the washing machine by calling the hardReset method of the WashingMachine class.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ControlActions extends PhysicalActions implements ControlInterface {
    public ControlActions() {

        super();
    }

    public void powerOn() {
        try {
            MSG.print("Powering on...");
            washingMachine.setStatus(StatusOfMachine.OK);
            System.out.println(getWashingMachine());

            washingMachine.setStatus(StatusOfMachine.OK);

        } catch (Exception e) {
            MSG.print("Powering on failed!");
            MSG.print(e.getMessage());
            washingMachine.setStatus(StatusOfMachine.ERROR);
        }
    }

    public void powerOff() {
        try {

            Thread.sleep(1000);
            MSG.print("Powering off...");

            washingMachine.setStatus(StatusOfMachine.OFF);

        } catch (Exception e) {
            MSG.print("Powering off failed!");
            MSG.print(e.getMessage());
            washingMachine.setStatus(StatusOfMachine.ERROR);
        }
    }

    public void startWashing(WashingMachineModes modeToStart, int kgOfClothes) {
        if (!PermissionValues.CLOTHES_CONTAINER.isValueInRange(kgOfClothes)) {
            throw new IllegalArgumentException("Clothes container is full");
        }

        try {
            Sensors sensors = new Sensors();
            sensors.checkAllComponents();

            MSG.print("Starting washing...");
            Thread.sleep(1000);

            WashingEffect.start(modeToStart);

            Thread.sleep(1000);
            MSG.print("Washing ended");
            washingMachine.setStatus(StatusOfMachine.OK);

        } catch (Exception e) {
            MSG.print("Starting washing failed!");
            MSG.print(e.getMessage());
        }
    }

    public void stopWashing() {
        try {
            MSG.print("Stopping washing...");

            washingMachine.setStatus(StatusOfMachine.STOPPED);

        } catch (Exception e) {
            MSG.print("Stopping washing failed!");
            MSG.print(e.getMessage());
            washingMachine.setStatus(StatusOfMachine.ERROR);
        }
    }

    public static WashingMachine reset() {
        return WashingMachine.hardReset();
    }
}