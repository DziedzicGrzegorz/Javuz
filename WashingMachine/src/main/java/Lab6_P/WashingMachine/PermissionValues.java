package Lab6_P.WashingMachine;

import lombok.Getter;

/**
 * The PermissionValues enum defines the permissible ranges for various settings in a washing machine.
 * <p>
 * Each enum constant represents a specific setting and has a minimum and maximum value.
 * <p>
 * Methods:
 * <p>
 * - isValueInRange:
 * Checks if a given value is within the permissible range for the setting.
 * <p>
 */
@Getter
public enum PermissionValues {

    TEMP_OF_WATER(0.0, 100.0),
    SPINNING_SPEED(0.0, 1200.0),
    PRE_WASH_TIME(0.0, 30.0),
    MAIN_WASH_TIME(15.0, 180.0),
    DETERGENT_CONTAINER_FABRIC_SOFTENER(0.0, 250.0),
    DETERGENT_CONTAINER_LAUNDRY(0.0, 50.0),
    CLOTHES_CONTAINER(0.0, 6.0),
    WATER_ON_DRUM(0.0, 2.0);

    private final double minValue;
    private final double maxValue;

    PermissionValues(double minValue, double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public boolean isValueInRange(double value) {
        return minValue <= value && value <= maxValue;
    }
}