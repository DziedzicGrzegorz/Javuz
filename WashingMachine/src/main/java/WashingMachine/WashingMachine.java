package WashingMachine;


import StatusOfMachine.StatusOfMachine;
import WashingMachine.Components.*;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * The WashingMachine class represents a washing machine.
 * <p>
 * Properties:
 * <p>
 * - status:
 * The current status of the washing machine. It can be OK, SERVICE_NEEDED, or ERROR.
 * <p>
 * - waterTemperature:
 * The current temperature of the water in the washing machine.
 * <p>
 * - spinningSpeed:
 * The current spinning speed of the washing machine.
 * <p>
 * - levelOfWater:
 * The current level of water in the washing machine.
 * <p>
 * Constructor:
 * - The constructor initializes the properties.
 * <p>
 * Methods:
 * <p>
 * - getInstance:
 * A static method that returns the singleton instance of the WashingMachine class.
 * <p>
 * - setWaterTemperature:
 * Sets the water temperature of the washing machine.
 * <p>
 * - setSpinningSpeed:
 * Sets the spinning speed of the washing machine.
 * <p>
 * - setLevelOfWater:
 * Sets the level of water in the washing machine.
 * <p>
 *
 * @see CheckAbleComponent
 * @see ComponentStatus
 */
@Data
public class WashingMachine {
    private static WashingMachine instance = null;

    WashingMachineModes activeMode = null;
    private StatusOfMachine status = StatusOfMachine.OFF;

    private final List<CheckAbleComponent> checkAbleComponents = Arrays.asList(
            new DetergentContainer(),
            new Drum(),
            new WaterFilter(),
            new WaterHeater(),
            new WaterPump(),
            new WaterTempSensor()
    );

    private WashingMachine() {
    }

    public static WashingMachine getInstance() {
        if (instance == null) {
            instance = new WashingMachine();
        }
        return instance;
    }

    public static WashingMachine hardReset() {
        instance = null;
        return WashingMachine.getInstance();
    }

    public <T> T getComponent(Class<T> componentType) {
        for (CheckAbleComponent component : checkAbleComponents) {
            if (componentType.isInstance(component)) {
                return componentType.cast(component);
            }
        }
        return null;
    }
}
