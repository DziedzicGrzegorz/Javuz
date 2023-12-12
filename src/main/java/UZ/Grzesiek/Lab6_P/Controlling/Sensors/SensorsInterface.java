package UZ.Grzesiek.Lab6_P.Controlling.Sensors;

import UZ.Grzesiek.Lab6_P.WashingMachine.Components.CheckAbleComponent;

public interface SensorsInterface {
    void checkAllComponents();

    void checkComponentStatus(CheckAbleComponent component);
}
