package WashingMachine;

import lombok.Getter;

/**
 * The PermissionValues enum defines the permissible ranges for various settings in a washing machine.
 * <p>
 * Each enum constant represents a specific setting and has a minimum and maximum value.
 * <p>
 * Methods:
 * <p>
 * - isValueOutOfRange:
 * Checks if a given value is within the permissible range for the setting.
 * <p>
 * Temp is on Celsius
 * Spinning speed is on RPM
 * wash time is on minutes
 * Detergent container fabric softener is on ml
 * water on drum is on liters
 */
@Getter
public enum PermissionValues {

    SPINNING_SPEED(0, 1200),
    PRE_WASH_TIME(0, 30),
    MAIN_WASH_TIME(15, 180),
    DETERGENT_CONTAINER_FABRIC_SOFTENER(0, 250),
    DETERGENT_CONTAINER_LAUNDRY(0, 50),
    CLOTHES_CONTAINER(0, 6),
    WATER_ON_DRUM(0, 2);

    private final int minValue;
    private final int maxValue;

    PermissionValues(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public boolean isValueOutOfRange(int value) {
        return value < minValue || value > maxValue;
    }
}