package UZ.Grzesiek.Lab6_P.Controlling;

import UZ.Grzesiek.Lab6_P.MSG;
import UZ.Grzesiek.Lab6_P.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.WashingMachineModes;

public class ControlActions implements ControlInterface {
    private StatusOfMachine status;



    @Override
    public StatusOfMachine powerOn() {
        try {
            MSG.print("Powering on...");
            //@TODO implement powering on and sensors

            status = StatusOfMachine.OK;

        } catch (Exception e) {
            MSG.print("Powering on failed!");
            MSG.print(e.getMessage());
            status = StatusOfMachine.ERROR;
        }
        return status;
    }

    @Override
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

    @Override
    public StatusOfMachine startWashing() {
        try {
            MSG.print("Starting washing...");
            //@TODO implement starting washing and sensors


            status = StatusOfMachine.WORKING;
            //@TODO here invoke method to start washing

        } catch (Exception e) {
            MSG.print("Starting washing failed!");
            MSG.print(e.getMessage());
            status = StatusOfMachine.ERROR;
        }
        return status;
    }

    @Override
    public StatusOfMachine getStatus() {
        return status;
    }

    @Override
    public void setStatus(StatusOfMachine status) {
        this.status = status;
    }


    @Override
    public StatusOfMachine pauseWashing() {
        return null;
    }
}
