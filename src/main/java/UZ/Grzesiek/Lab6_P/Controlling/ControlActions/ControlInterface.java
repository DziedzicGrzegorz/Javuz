package UZ.Grzesiek.Lab6_P.Controlling.ControlActions;

import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachineModes;


public interface ControlInterface {
    void powerOn();
    void powerOff();
    void startWashing(WashingMachineModes modeToStart, int kgOfClothes);
    void stopWashing();
}
