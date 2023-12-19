package WashingMachine;

import lombok.Getter;

/**
 * The PermissionValuesForModes enum defines the permissible ranges for various modes in a washing machine.
 * <p>
 * Each enum constant represents a specific mode and has a minimum and maximum value.
 * <p>
 * Methods:
 * <p>
 * - isValueOutOfRange:
 * Checks if a given value is within the permissible range for the mode.
 * <p>
 */
@Getter
public enum PermissionValuesForModes {

    TEMP_OF_WATER(0, 100),
    SPINNING_SPEED(0, 1200),
    PRE_WASH_TIME(0, 15),
    MAIN_WASH_TIME(6, 180);

    private final int minValue;
    private final int maxValue;

    PermissionValuesForModes(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public boolean isValueOutOfRange(int value) {
        return value < minValue || value > maxValue;
    }
}
