package UZ.Grzesiek.Lab6_P;


/**
 * Defines different modes of operation for a washing machine.
 * <p>
 * Includes five predefined modes:
 * - WASHING_CLASSIC
 * - WASHING_DAILY
 * - SPINNING
 * - DRYING
 * - RINSING
 * <p>
 * You can also create a custom mode using the `customMode` method, for example:
 * <p>
 * MachineModes customMode = MachineModes.customMode(30, 3, 15, true, 600);
 * <p>
 * Each mode includes configurations for:
 * - waterTemperature: The temperature of the water (in degrees Celsius).
 * - preWashTime: The pre-wash time (in minutes).
 * - mainWashTime: The main wash time (in minutes).
 * - extraRinse: If true, an extra rinse cycle is added.
 * - spinSpeed: The spin speed (in RPM).
 */
public class WashingMachineModes extends WashingModeSettings {
    public static final WashingMachineModes WASHING_CLASSIC = new WashingMachineModes(90, 10, 30, true, 1200);
    public static final WashingMachineModes WASHING_DAILY = new WashingMachineModes(60, 5, 20, false, 800);
    public static final WashingMachineModes SPINNING = new WashingMachineModes(30, 3, 15, true, 600);
    public static final WashingMachineModes DRYING = new WashingMachineModes(40, 0, 20, false, 800);
    public static final WashingMachineModes RINSING = new WashingMachineModes(30, 3, 15, true, 600);


    private WashingMachineModes(int waterTemperature, int preWashTime, int mainWashTime, boolean extraRinse, int spinSpeed) {
        this.waterTemperature = waterTemperature;
        this.preWashTime = preWashTime;
        this.mainWashTime = mainWashTime;
        this.extraRinse = extraRinse;
        this.spinningSpeed = spinSpeed;
    }

    static WashingMachineModes customMode(int waterTemperature, int preWashTime, int mainWashTime, boolean extraRinse, int spinSpeed) {
        return new WashingMachineModes(waterTemperature, preWashTime, mainWashTime, extraRinse, spinSpeed);
    }

    @Override
    public String toString() {
        return STR."WashingMode => waterTemperature=\{waterTemperature}, preWashTime=\{preWashTime}, mainWashTime=\{mainWashTime}, extraRinse=\{extraRinse}, spinSpeed=\{spinningSpeed}";
    }
}