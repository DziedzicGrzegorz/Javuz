package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import lombok.Data;
/**
 * The DetergentContainer class implements the CheckAbleComponent interface and represents a detergent container in a washing machine.
 * <p>
 * Properties:
 * <p>
 * - status:
 *   The current status of the detergent container. It can be OK, SERVICE_NEEDED, or ERROR.
 * <p>
 * - fabricSoftenerLevel:
 *   The current level of fabric softener in the detergent container.
 * <p>
 * - laundryDetergentLevel:
 *   The current level of laundry detergent in the detergent container.
 * <p>
 * Constructor:
 * - The constructor calls the setDefaultValue method to initialize the properties.
 * <p>
 * Methods:
 * <p>
 * - setDefaultValue:
 *      Sets the default values for the properties.
 *      It sets the status to OK, and the fabric softener and laundry detergent levels to 0.
 * <p>
 * @see CheckAbleComponent
 * @see ComponentStatus
 */
@Data
public class DetergentContainer implements CheckAbleComponent {
    private ComponentStatus status;
    private int fabricSoftenerLevel;
    private int laundryDetergentLevel;

    public DetergentContainer() {
        setDefaultValue();
    }

    public void setDefaultValue() {
        this.status = ComponentStatus.OK;
        this.fabricSoftenerLevel = 0;
        this.laundryDetergentLevel = 0;
    }
}
