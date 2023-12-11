package UZ.Grzesiek.Lab6_P.Controlling;

import UZ.Grzesiek.Lab6_P.Utils.MSG;
import UZ.Grzesiek.Lab6_P.StatusOfMachine.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachine;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachineModes;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ControlActions extends PhysicalActions {
    public static void main(String[] args) {
        ControlActions controlActions = new ControlActions();
        controlActions.powerOn();
        controlActions.startWashing(WashingMachineModes.WASHING_CLASSIC, 5);
        //i want to
        controlActions.powerOff();
    }

    private StatusOfMachine status;


    public ControlActions(WashingMachine washingMachine) {
        super(washingMachine);
    }

    public ControlActions() {
        super(WashingMachine.getInstance());
    }


    public StatusOfMachine powerOn() {
        try {
            MSG.print("Powering on...");
            //@TODO implement powering on and sensors
            System.out.println(getWashingMachine());

            status = StatusOfMachine.OK;

        } catch (Exception e) {
            MSG.print("Powering on failed!");
            MSG.print(e.getMessage());
            status = StatusOfMachine.ERROR;
        }
        return status;
    }

    public StatusOfMachine powerOff() {
        try {
            MSG.print("Powering off...");
            //@TODO implement powering off and sensors

            status = StatusOfMachine.OFF;

        } catch (Exception e) {
            MSG.print("Powering off failed!");
            MSG.print(e.getMessage());
            status = StatusOfMachine.ERROR;
        }
        return status;
    }

    public StatusOfMachine startWashing(WashingMachineModes modeToStart, int kgOfClothes) {
        try {
            Sensors sensors = new Sensors(washingMachine);
            StatusOfMachine pressureStatus = sensors.PressureOfWater();
            StatusOfMachine filterStatus = sensors.checkFilter();

            if (pressureStatus == StatusOfMachine.ERROR || filterStatus == StatusOfMachine.ERROR) {
                MSG.print("Error in sensors. Cannot start washing.");
                return StatusOfMachine.ERROR;
            }
            if (pressureStatus == StatusOfMachine.SERVICE_NEEDED || filterStatus == StatusOfMachine.SERVICE_NEEDED) {
                MSG.print("Service needed. Cannot start washing.");
                return StatusOfMachine.SERVICE_NEEDED;
            }
            StatusOfMachine balanceDrumStatus = balanceDrumContents();

            StatusOfMachine pumpWaterStatus = pumpWater();
            StatusOfMachine heatWaterStatus = heatWater(modeToStart.getWaterTemperature());

            if (pumpWaterStatus != StatusOfMachine.OK || heatWaterStatus != StatusOfMachine.OK || balanceDrumStatus != StatusOfMachine.OK) {
                MSG.print("Error in physical actions. Cannot start washing.");
                return StatusOfMachine.ERROR;
            }

            MSG.print("Starting washing...");
            Thread.sleep(1000);

            MSG.print("Washing ended");

            return StatusOfMachine.OK;

        } catch (Exception e) {
            MSG.print("Starting washing failed!");
            MSG.print(e.getMessage());
            return StatusOfMachine.ERROR;
        }
    }

    public StatusOfMachine StopWashing() {
        try {
            MSG.print("Stopping washing...");
            //@TODO implement stopping washing and sensors

            status = StatusOfMachine.STOPPED;

        } catch (Exception e) {
            MSG.print("Stopping washing failed!");
            MSG.print(e.getMessage());
            status = StatusOfMachine.ERROR;
        }
        return status;
    }


    public StatusOfMachine pauseWashing() {
        try {
            MSG.print("Pausing washing...");
            //@TODO implement pausing washing and sensors

            status = StatusOfMachine.STOPPED;

        } catch (Exception e) {
            MSG.print("Pausing washing failed!");
            MSG.print(e.getMessage());
            status = StatusOfMachine.ERROR;
        }
        return status;

    }

    public static WashingMachine reset() {
        return WashingMachine.hardReset();
    }
}
