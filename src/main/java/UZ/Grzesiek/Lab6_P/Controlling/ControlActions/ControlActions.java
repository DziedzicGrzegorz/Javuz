package UZ.Grzesiek.Lab6_P.Controlling.ControlActions;

import UZ.Grzesiek.Lab6_P.WashingMachine.PermissionValues;
import UZ.Grzesiek.Lab6_P.Controlling.PhysicalActions.PhysicalActions;
import UZ.Grzesiek.Lab6_P.Controlling.Sensors.Sensors;
import UZ.Grzesiek.Lab6_P.StatusOfMachine.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.Utils.MSG;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingEffect.WashingEffect;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachine;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachineModes;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The ControlActions class extends the PhysicalActions class.
 * It provides methods to control the actions of a washing machine.
 * These actions include powering on and off the machine, starting and stopping the washing process, and pausing the washing process.
 * Each method returns a StatusOfMachine object that indicates the status of the machine after the action is performed.
 * The class also includes a method to reset the washing machine.
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
        if(!PermissionValues.CLOTHES_CONTAINER.isValueInRange(kgOfClothes)){
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