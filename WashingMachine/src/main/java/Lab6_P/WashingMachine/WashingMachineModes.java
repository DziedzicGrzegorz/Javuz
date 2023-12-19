package Lab6_P.WashingMachine;

import Lab6_P.WashingMachine.Components.CheckAbleComponent;
import Lab6_P.WashingMachine.Components.ComponentStatus;
import lombok.Data;

/**
 * The WashingMachineModes class represents the different modes of a washing machine.
 * <p>
 * Properties:
 * <p>
 * - waterTemperature:
 * The water temperature for the wash.
 * <p>
 * - preWashTime:
 * The time for the pre-wash phase.
 * <p>
 * - mainWashTime:
 * The time for the main wash phase.
 * <p>
 * - spinningSpeed:
 * The speed of the spinning phase.
 * <p>
 * - extraRinse:
 * Whether an extra rinse is required.
 * <p>
 * - extraRinseTime:
 * The time for the extra rinse phase.
 * <p>
 * Constructor:
 * - The constructor validates the mode settings and sets the properties.
 * <p>
 * Methods:
 * <p>
 * - customMode:
 * Creates a custom washing machine mode with the given parameters.
 * <p>
 * - validateModeSettings:
 * Validates the settings for a washing machine mode.
 * <p>
 * - validateSetting:
 * Validates a specific setting for a washing machine mode.
 * <p>
 *
 * @see CheckAbleComponent
 * @see ComponentStatus
 */
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
        validateSetting(PermissionValuesForModes.TEMP_OF_WATER, waterTemperature);
        validateSetting(PermissionValuesForModes.SPINNING_SPEED, spinSpeed);
        validateSetting(PermissionValuesForModes.PRE_WASH_TIME, preWashTime);
        validateSetting(PermissionValuesForModes.MAIN_WASH_TIME, mainWashTime);
    }

    private static void validateSetting(PermissionValuesForModes validateModeSettings, int actualValue) {
        if (!validateModeSettings.isValueInRange(actualValue)) {
            throw new IllegalArgumentException(STR."\{validateModeSettings} is out of the acceptable range!");
        }
    }
}