package UZ.Grzesiek.Lab6_P.Controlling;

import UZ.Grzesiek.Lab6_P.MSG;
import UZ.Grzesiek.Lab6_P.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.WashingMachine;
import UZ.Grzesiek.Lab6_P.WashingMachineModes;

public class ControlActions extends PhysicalActions {
    public static void main(String[] args) {
        ControlActions controlActions = new ControlActions();
        controlActions.powerOn();
        controlActions.startWashing(WashingMachineModes.WASHING_CLASSIC,5);
        controlActions.powerOff();
    }

    private StatusOfMachine status;

    ControlActions(WashingMachine washingMachine) {
        super(washingMachine);
    }

    ControlActions() {
        super(new WashingMachine());
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
            MSG.print("Starting washing...");
            //@TODO implement starting washing and sensors


            status = StatusOfMachine.WORKING;
            //@TODO here invoke method to start washing

            washingMachine.setActiveMode(modeToStart);

           if(heatWater(modeToStart.getWaterTemperature()) != StatusOfMachine.OK){
               System.out.println(STR."Error while heating water to \{modeToStart.getWaterTemperature()} degrees Celsius.");
           }
            washingMachine.setTemperatureOfWater(modeToStart.getWaterTemperature());

            washingMachine.setSpinningSpeed(modeToStart.getSpinningSpeed());
            washingMachine.setClothesContainer(kgOfClothes);



        } catch (Exception e) {
            MSG.print("Starting washing failed!");
            MSG.print(e.getMessage());
            status = StatusOfMachine.ERROR;
        }
        return status;
    }

    public StatusOfMachine getStatus() {
        return status;
    }

    public void setStatus(StatusOfMachine status) {
        this.status = status;
    }


    public StatusOfMachine pauseWashing() {
        return null;
    }
}
