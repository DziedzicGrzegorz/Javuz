package Lab6_P.Controlling.Sensors;


import Lab6_P.WashingMachine.Components.CheckAbleComponent;

public interface SensorsInterface {
    void checkAllComponents() throws Exception;

    void checkComponentStatus(CheckAbleComponent component) throws Exception;
}
