package UZ.Grzesiek.Lab6_P;

import UZ.Grzesiek.Lab6_P.Controlling.ControlActions.ControlActions;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachineModes;

public class Main {
    public static void main(String[] args) {
        ControlActions controlActions = new ControlActions();
        controlActions.powerOn();
        controlActions.startWashing(WashingMachineModes.RINSING, 10);
        controlActions.stopWashing();
        controlActions.powerOff();
    }
}
