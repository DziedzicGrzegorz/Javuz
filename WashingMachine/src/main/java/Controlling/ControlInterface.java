package Controlling;


import WashingMachine.WashingMachineModes;

public interface ControlInterface {
    void powerOn();

    void powerOff();

    void startWashing(WashingMachineModes modeToStart, int kgOfClothes, int FabricSoftener, int LaundryDetergent) throws Exception;

    void stopWashing();
}
