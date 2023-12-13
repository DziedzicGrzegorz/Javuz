package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import lombok.Data;
/**
 * The WaterFilter class implements the CheckAbleComponent interface and represents a water filter in a washing machine.
 * <p>
 * Properties:
 * <p>
 * - status:
 *   The current status of the water filter. It can be OK, SERVICE_NEEDED, or ERROR.
 * <p>
 * - LevelOfPollution:
 *   The current level of pollution in the water filter.
 * <p>
 * Constructor:
 * - The constructor calls the setDefaultValue method to initialize the properties.
 * <p>
 * Methods:
 * <p>
 * - setDefaultValue:
 *   Sets the default values for the properties.
 *   It sets the status to OK, and the level of pollution to 0.
 * <p>
 * @see CheckAbleComponent
 * @see ComponentStatus
 */
@Data
public class WaterPump implements CheckAbleComponent {
    private ComponentStatus status;
    private int waterPressure;

    public WaterPump() {
        setDefaultValue();
    }

    @Override
    public void setDefaultValue() {
        this.status = ComponentStatus.OK;
        this.waterPressure = 0;
    }
}
