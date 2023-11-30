package UZ.Grzesiek.Lab6_P.WashingMachine;

import java.security.SecureRandom;


public class WashingMachine  {
    private static WashingMachine instance = null;

    private WashingMachine() {}
    public static WashingMachine getInstance() {
        if (instance == null) {
            instance = new WashingMachine();
        }
        return instance;
    }
    WashingMachineModes activeMode = null;
    private int temperatureOfWater=0;
    private int spinningSpeed=0;
    private int detergentContainer=0;
    private int weightOfClothesContainer =0;
    private int levelOfWater=0;
    WaterFilterStatus waterFilterStatus=WaterFilterStatus.OK;
    public static WashingMachine hardReset(){
        instance = new WashingMachine();
        return instance;
    }
    public double getWaterPressure() {
        SecureRandom random = new SecureRandom();
        return random.nextDouble(2);
    }


    public int getLevelOfWater() {
        return levelOfWater;
    }

    public void setLevelOfWater(int levelOfWater) {
        this.levelOfWater = levelOfWater;
    }

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

    public int getWeightOfClothesContainer() {
        return weightOfClothesContainer;
    }

    public void setWeightOfClothesContainer(int weightOfClothesContainer) {
        this.weightOfClothesContainer = weightOfClothesContainer;
    }

    public WaterFilterStatus getWaterFilterStatus() {
        return waterFilterStatus;
    }

    public void setWaterFilterStatus(WaterFilterStatus waterFilterStatus) {
        this.waterFilterStatus = waterFilterStatus;
    }


    @Override
    public String toString() {
        return STR."WashingMachine{mode=\{activeMode}, temperatureOfWater=\{temperatureOfWater}, spinningSpeed=\{spinningSpeed}, detergentContainer=\{detergentContainer}, clothesContainer=\{weightOfClothesContainer}, waterFilterStatus=\{waterFilterStatus}\{'}'}";
    }
}
