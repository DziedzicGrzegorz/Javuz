package UZ.Grzesiek.Lab6_P.WashingMachine;

import lombok.Getter;

@Getter
public enum PermissionValuesForModes {

    TEMP_OF_WATER(0, 100),
    SPINNING_SPEED(0, 1200),
    PRE_WASH_TIME(0, 30),
    MAIN_WASH_TIME(15, 180);

    private final int minValue;
    private final int maxValue;

    PermissionValuesForModes(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    public boolean isValueInRange(int value){
        return minValue <= value && value <= maxValue;
    }
}
