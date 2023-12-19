import Controlling.ControlActions;
import WashingMachine.WashingMachineModes;

public class Main {
    public static void main(String[] args) throws Exception {
        ControlActions controlActions = new ControlActions();
        controlActions.powerOn();
        controlActions.startWashing(WashingMachineModes.customMode(30, 3, 8, true, 600), 5, 5, 5);
        controlActions.powerOff();
        controlActions.powerOn();
        controlActions.startWashing(WashingMachineModes.WASHING_DAILY, 5, 5123, 5123123);
    }
}