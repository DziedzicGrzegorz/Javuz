package Lab6_P;


import Lab6_P.Controlling.ControlActions.ControlActions;
import Lab6_P.WashingMachine.WashingMachineModes;

public class Main {
    public static void main(String[] args) {
        ControlActions controlActions = new ControlActions();
        controlActions.powerOn();
        controlActions.startWashing(WashingMachineModes.customMode(30, 3, 8, true, 600), 5);
        controlActions.powerOff();
    }
}