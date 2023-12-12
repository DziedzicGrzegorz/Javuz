package UZ.Grzesiek.Lab6_P.WashingMachine;

import UZ.Grzesiek.Lab6_P.StatusOfMachine.StatusOfMachine;
import UZ.Grzesiek.Lab6_P.WashingMachine.Components.DetergentContainer;
import UZ.Grzesiek.Lab6_P.WashingMachine.Components.Drum;
import UZ.Grzesiek.Lab6_P.WashingMachine.Components.WaterFilter;
import UZ.Grzesiek.Lab6_P.WashingMachine.Components.WaterHeater;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;




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
 */
@Setter
@Getter
@ToString
public class WashingMachine  {
    private static WashingMachine instance = null;

    WashingMachineModes activeMode = null;
    private StatusOfMachine status = StatusOfMachine.OFF;

    final public DetergentContainer detergentContainer = new DetergentContainer();
    final public Drum drum = new Drum();
    final public WaterFilter waterFilter = new WaterFilter();
    final public WaterHeater waterHeater = new WaterHeater();


    private int waterTemperature;
    private int levelOfWater;
    private int spinningSpeed;



    private WashingMachine() {}
    public static WashingMachine getInstance() {
        if (instance == null) {
            instance = new WashingMachine();
        }
        return instance;
    }

    public static WashingMachine hardReset(){
        instance = null;
        return WashingMachine.getInstance();
    }
}
