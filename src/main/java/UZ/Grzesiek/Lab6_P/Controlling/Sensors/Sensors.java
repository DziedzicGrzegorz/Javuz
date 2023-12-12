package UZ.Grzesiek.Lab6_P.Controlling.Sensors;

import UZ.Grzesiek.Lab6_P.Utils.MSG;
import UZ.Grzesiek.Lab6_P.StatusOfMachine.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.WashingMachine.Components.*;
import UZ.Grzesiek.Lab6_P.WashingMachine.WashingMachine;

import java.util.Arrays;
import java.util.List;

public class Sensors {
    private final WashingMachine washingMachine;

    public Sensors() {
        this.washingMachine = WashingMachine.getInstance();
    }

    public void checkAllComponents() {
        List<CheckableComponent> components = Arrays.asList(
                washingMachine.getComponent(DetergentContainer.class),
                washingMachine.getComponent(Drum.class),
                washingMachine.getComponent(WaterFilter.class),
                washingMachine.getComponent(WaterHeater.class),
                washingMachine.getComponent(WaterPump.class)
        );

        for (CheckableComponent component : components) {
            checkComponentStatus(component);
        }
    }

    private void checkComponentStatus(CheckableComponent component) {
        ComponentStatus status = component.getStatus();
        String componentName = component.getClass().getSimpleName();

        try {
            MSG.print(STR."Checking \{componentName}...");
            Thread.sleep(1000);

            if (status != ComponentStatus.OK) {
                MSG.print(STR."\{componentName} needs service!");
                washingMachine.setStatus(StatusOfMachine.SERVICE_NEEDED);
            } else {
                MSG.print(STR."\{componentName} is OK!");
            }
        } catch (Exception e) {
            MSG.print(STR."Checking \{componentName} failed!");
            MSG.print(e.getMessage());
        }
    }
}