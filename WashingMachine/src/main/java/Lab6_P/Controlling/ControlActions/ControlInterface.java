package Lab6_P.Controlling.ControlActions;


import Lab6_P.WashingMachine.WashingMachineModes;

public interface ControlInterface {
    void powerOn();

    void powerOff();

    void startWashing(WashingMachineModes modeToStart, int kgOfClothes);

    void stopWashing();
}
