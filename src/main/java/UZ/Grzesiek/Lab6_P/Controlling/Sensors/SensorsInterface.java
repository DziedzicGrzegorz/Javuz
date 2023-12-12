package UZ.Grzesiek.Lab6_P.Controlling.Sensors;

import UZ.Grzesiek.Lab6_P.Utils.SpecificComponentException;
import UZ.Grzesiek.Lab6_P.WashingMachine.Components.CheckAbleComponent;

public interface SensorsInterface {
    void checkAllComponents() throws Exception;

    void checkComponentStatus(CheckAbleComponent component) throws Exception;
}
