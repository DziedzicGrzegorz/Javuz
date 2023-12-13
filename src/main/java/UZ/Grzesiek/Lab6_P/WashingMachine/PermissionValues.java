package UZ.Grzesiek.Lab6_P.WashingMachine;

import lombok.Getter;
/**
 * The PermissionValues enum defines the permissible ranges for various settings in a washing machine.
 * <p>
 * Each enum constant represents a specific setting and has a minimum and maximum value.
 * <p>
 * Methods:
 * <p>
 * - isValueInRange:
 *   Checks if a given value is within the permissible range for the setting.
 * <p>
 */
@Getter
public enum PermissionValues {

    TEMP_OF_WATER(0, 100),
    SPINNING_SPEED(0, 1200),
    PRE_WASH_TIME(0, 30),
    MAIN_WASH_TIME(15, 180),
    DETERGENT_CONTAINER_FABRIC_SOFTENER(0, 250),
    DETERGENT_CONTAINER_LAUNDRY(0, 50),
    CLOTHES_CONTAINER(0, 6),
    //2 LITERS OF
    WATER_ON_DRUM(0, 2);

    private final int minValue;
    private final int maxValue;

    PermissionValues(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    public boolean isValueInRange(int value) {
        return minValue <= value && value <= maxValue;
    }
}