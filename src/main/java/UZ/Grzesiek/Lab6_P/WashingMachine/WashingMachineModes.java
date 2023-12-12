package UZ.Grzesiek.Lab6_P.WashingMachine;

import UZ.Grzesiek.Lab6_P.WashingMachine.WashingEffect.WashingEffect;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class WashingMachineModes {
    protected int waterTemperature;
    protected int preWashTime;
    protected int mainWashTime;
    protected int spinningSpeed;
    protected boolean extraRinse;
    public static final int extraRinseTime = 5;

    public static final WashingMachineModes WASHING_CLASSIC = new WashingMachineModes(90, 10, 30, true, 1200);
    public static final WashingMachineModes WASHING_DAILY = new WashingMachineModes(60, 5, 20, false, 800);
    public static final WashingMachineModes SPINNING = new WashingMachineModes(30, 3, 15, true, 600);
    public static final WashingMachineModes DRYING = new WashingMachineModes(40, 0, 20, false, 800);
    public static final WashingMachineModes RINSING = new WashingMachineModes(30, 3, 15, true, 600);
    private WashingMachineModes(int waterTemperature, int preWashTime, int mainWashTime, boolean extraRinse, int spinSpeed) {
        validateModeSettings(waterTemperature, preWashTime, mainWashTime, spinSpeed);
        this.waterTemperature = waterTemperature;
        this.preWashTime = preWashTime;
        this.mainWashTime = mainWashTime;
        this.extraRinse = extraRinse;
        this.spinningSpeed = spinSpeed;
    }

    public static WashingMachineModes customMode(int waterTemperature, int preWashTime, int mainWashTime, boolean extraRinse, int spinSpeed) {
        validateModeSettings(waterTemperature, preWashTime, mainWashTime, spinSpeed);
        return new WashingMachineModes(waterTemperature, preWashTime, mainWashTime, extraRinse, spinSpeed);
    }
    private static void validateModeSettings(int waterTemperature, int preWashTime, int mainWashTime, int spinSpeed) {
        validateSetting(PermissionValuesForModes.TEMP_OF_WATER, waterTemperature, "Water temperature");
        validateSetting(PermissionValuesForModes.SPINNING_SPEED, spinSpeed, "Spinning speed");
        validateSetting(PermissionValuesForModes.PRE_WASH_TIME, preWashTime, "Pre wash time");
        validateSetting(PermissionValuesForModes.MAIN_WASH_TIME, mainWashTime, "Main wash time");
    }
    private static void validateSetting(PermissionValuesForModes permissionValue, int actualValue, String settingName) {
        if (!permissionValue.isValueInRange(actualValue)) {
            throw new IllegalArgumentException(STR."\{settingName} is out of the acceptable range!");
        }
    }
}