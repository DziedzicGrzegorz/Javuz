package UZ.Grzesiek.Lab6_P.Controlling;

import UZ.Grzesiek.Lab6_P.StatusOfMachine;

public interface ControlInterface {
    StatusOfMachine powerOn();
    StatusOfMachine powerOff();
    StatusOfMachine startWashing();
    StatusOfMachine getStatus();
    void setStatus(StatusOfMachine status);
    StatusOfMachine pauseWashing();
}
