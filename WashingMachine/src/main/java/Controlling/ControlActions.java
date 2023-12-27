package Controlling;

import StatusOfMachine.StatusOfMachine;
import Utils.MSG;
import WashingMachine.PermissionValues;
import WashingMachine.WashingEffect.WashingEffect;
import WashingMachine.WashingMachine;
import WashingMachine.WashingMachineModes;
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
    public static int ZERO_LITERS_OF_WATER = 0;
    WashingMachineModes modeToStart = WashingMachineModes.DEFAULT;

    public ControlActions() {
        super();
    }

    @Override
    public void powerOn() {
        try {
            MSG.print("Powering on...");
            washingMachine.setStatus(StatusOfMachine.OK);

        } catch (Exception e) {
            MSG.print("Powering on failed!");
            MSG.print(e.getMessage());
            washingMachine.setStatus(StatusOfMachine.ERROR);
        }
    }

    @Override
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

    @Override
    public void startWashing(WashingMachineModes modeToSet, int kgOfClothes, int FabricSoftener, int LaundryDetergent) throws Exception {
        modeToStart = modeToSet;

        validateWashingMachineState();
        validateClothesWeight(kgOfClothes);

        prepareForWashing(FabricSoftener, LaundryDetergent);
        performWashingCycle(modeToStart);

        finishWashing();
    }

    private void validateWashingMachineState() {
        if (washingMachine.getStatus() == StatusOfMachine.OFF) {
            throw new IllegalStateException("Washing machine power is off. Cannot start washing.");
        }
    }

    private void validateClothesWeight(int kgOfClothes) {
        if (PermissionValues.CLOTHES_CONTAINER.isValueOutOfRange(kgOfClothes)) {
            throw new IllegalArgumentException("The weight of clothes exceeds the container's limit");
        }
    }

    private void prepareForWashing(int FabricSoftener, int LaundryDetergent) throws Exception {
        addFabricSoftener(FabricSoftener);
        addLaundryDetergent(LaundryDetergent);

        new Sensors();
        balanceDrumContents();

        MSG.print("Starting washing...");
        Thread.sleep(1000);
        pumpWater(WashingMachineModes.waterToPumpInLiters);
        heatWater(WashingMachineModes.DEFAULT.getWaterTemperature());
    }

    private void performWashingCycle(WashingMachineModes modeToStart) throws InterruptedException {
        WashingEffect washingEffect = new WashingEffect(modeToStart);
        pumpWater(ZERO_LITERS_OF_WATER);
        washingEffect.extraRinse(WashingMachineModes.extraRinseTime);
        Thread.sleep(1000);
        MSG.print("Washing ended");
    }

    private void finishWashing() {
        AfterWashingResetValues();
        washingMachine.setStatus(StatusOfMachine.OK);
    }

    @Override
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

    public WashingMachine reset() {
        if (washingMachine.getStatus() != StatusOfMachine.OFF) {
            stopWashing();
            powerOff();
        }
        return WashingMachine.hardReset();
    }
}