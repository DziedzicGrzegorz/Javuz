package UZ.Grzesiek.Lab6_P.WashingMachine;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class WashingMachineModes{
    protected int waterTemperature;
    protected int preWashTime;
    protected int mainWashTime;
    protected boolean extraRinse;
    protected int spinningSpeed;

    public static final WashingMachineModes WASHING_CLASSIC = new WashingMachineModes(90, 10, 30, true, 1200);
    public static final WashingMachineModes WASHING_DAILY = new WashingMachineModes(60, 5, 20, false, 800);
    public static final WashingMachineModes SPINNING = new WashingMachineModes(30, 3, 15, true, 600);
    public static final WashingMachineModes DRYING = new WashingMachineModes(40, 0, 20, false, 800);
    public static final WashingMachineModes RINSING = new WashingMachineModes(30, 3, 15, true, 600);



    static WashingMachineModes customMode(int waterTemperature, int preWashTime, int mainWashTime, boolean extraRinse, int spinSpeed) {
        return new WashingMachineModes(waterTemperature, preWashTime, mainWashTime, extraRinse, spinSpeed);
    }
}
