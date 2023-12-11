package UZ.Grzesiek.Lab6_P.WashingMachine;

import java.security.SecureRandom;


/**
 * The WashingMachine class represents a washing machine object.
 * It provides methods to control and monitor the washing machine's status and settings.
 *
 * <p>
 *     The class includes the following functionalities:
 *     - Getting and setting the active mode of the washing machine.
 *     - Getting and setting the temperature of the water.
 *     - Getting and setting the spinning speed of the machine.
 *     - Getting and setting the detergent container level.
 *     - Getting and setting the weight of the clothes container.
 *     - Getting and setting the level of water in the machine.
 *     - Getting and setting the status of the water filter.
 *     - Getting the water pressure.
 *     - Performing a hard reset of the washing machine.
 * </p>
 *
 * <p>
 *     The class also includes the nested enum {@link WaterFilterStatus} that represents the status of the water filter.
 *     The class also relies on the nested class {@link WashingMachineModes} for representing the different modes of operation.
 * </p>
 *
 * <p>
 *     Usage example:
 * </p>
 *
 * <pre>
 *     WashingMachine washingMachine = WashingMachine.getInstance();
 *     washingMachine.setActiveMode(WashingMachineModes.WASHING_CLASSIC);
 *     washingMachine.setTemperatureOfWater(60);
 *     washingMachine.setSpinningSpeed(1200);
 *     washingMachine.setDetergentContainer(10);
 *     washingMachine.setWeightOfClothesContainer(5);
 *     washingMachine.setLevelOfWater(3);
 *     washingMachine.setWaterFilterStatus(WashingMachine.WaterFilterStatus.OK);
 *     double waterPressure = washingMachine.getWaterPressure();
 * </pre>
 *
 * @see WashingMachineModes
 * @see WaterFilterStatus
 */
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
