package UZ.Grzesiek.Lab6_P;
abstract public class WashingModeSettings {
    protected int waterTemperature;
    protected int preWashTime;
    protected int mainWashTime;
    protected boolean extraRinse;
    protected int spinningSpeed;

    public int getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(int waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public int getPreWashTime() {
        return preWashTime;
    }

    public void setPreWashTime(int preWashTime) {
        this.preWashTime = preWashTime;
    }

    public int getMainWashTime() {
        return mainWashTime;
    }

    public void setMainWashTime(int mainWashTime) {
        this.mainWashTime = mainWashTime;
    }

    public boolean isExtraRinse() {
        return extraRinse;
    }

    public void setExtraRinse(boolean extraRinse) {
        this.extraRinse = extraRinse;
    }

    public int getSpinningSpeed() {
        return spinningSpeed;
    }

    public void setSpinningSpeed(int spinningSpeed) {
        this.spinningSpeed = spinningSpeed;
    }

}