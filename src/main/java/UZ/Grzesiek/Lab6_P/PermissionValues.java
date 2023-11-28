package UZ.Grzesiek.Lab6_P;


public enum PermissionValues {

    TEMP_OF_WATER(0, 100),
    SPINNING_SPEED(0, 1200),
    PRE_WASH_TIME(0, 30),
    MAIN_WASH_TIME(15, 180),
    DETERGENT_CONTAINER(0, 250),
    CLOTHES_CONTAINER(0, 6);

    private final int minValue;
    private final int maxValue;

    PermissionValues(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return this.minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}