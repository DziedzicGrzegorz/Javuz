package Controlling;


import WashingMachine.Components.CheckAbleComponent;

public interface SensorsInterface {
    void checkAllComponents() throws Exception;

    void checkComponentStatus(CheckAbleComponent component) throws Exception;
}
