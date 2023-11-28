package UZ.Grzesiek.Lab6_P;


public class WashingMachine  {

    public WashingMachine() {
    }
    WashingMachineModes activeMode = null;
    private int temperatureOfWater=0;
    private int spinningSpeed=0;
    private int detergentContainer=0;
    private int clothesContainer=0;
    WaterFilterStatus waterFilterStatus=WaterFilterStatus.OK;
    public enum WaterFilterStatus {
        OK,
        SERVICE_NEEDED;
    }

    public WashingMachineModes getActiveMode() {
        return activeMode;
    }

    public void setActiveMode(WashingMachineModes activeMode) {
        this.activeMode = activeMode;
    }

    public int getTemperatureOfWater() {
        return temperatureOfWater;
    }

    public void setTemperatureOfWater(int temperatureOfWater) {
        this.temperatureOfWater = temperatureOfWater;
    }

    public int getSpinningSpeed() {
        return spinningSpeed;
    }

    public void setSpinningSpeed(int spinningSpeed) {
        this.spinningSpeed = spinningSpeed;
    }

    public int getDetergentContainer() {
        return detergentContainer;
    }

    public void setDetergentContainer(int detergentContainer) {
        this.detergentContainer = detergentContainer;
    }

    public int getClothesContainer() {
        return clothesContainer;
    }

    public void setClothesContainer(int clothesContainer) {
        this.clothesContainer = clothesContainer;
    }

    public WaterFilterStatus getWaterFilterStatus() {
        return waterFilterStatus;
    }

    public void setWaterFilterStatus(WaterFilterStatus waterFilterStatus) {
        this.waterFilterStatus = waterFilterStatus;
    }

    @Override
    public String toString() {
        return STR."WashingMachine{mode=\{activeMode}, temperatureOfWater=\{temperatureOfWater}, spinningSpeed=\{spinningSpeed}, detergentContainer=\{detergentContainer}, clothesContainer=\{clothesContainer}, waterFilterStatus=\{waterFilterStatus}\{'}'}";
    }
}
