package UZ.Grzesiek.Lab6_P.Controlling;

import UZ.Grzesiek.Lab6_P.StatusOfMachine.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachineModes;

/**
 * The ControlInterface interface defines the methods for controlling a machine.
 */
public interface ControlInterface {
    StatusOfMachine powerOn();
    StatusOfMachine powerOff();
    public StatusOfMachine startWashing(WashingMachineModes modeToStart, int kgOfClothes);

    StatusOfMachine stopWashing();
}
