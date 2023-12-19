package WashingMachine.Components;

import lombok.Data;

/**
 * The Drum class implements the CheckAbleComponent interface and represents a drum in a washing machine.
 * <p>
 * Properties:
 * <p>
 * - status:
 * The current status of the drum. It can be OK, SERVICE_NEEDED, or ERROR.
 * <p>
 * - capacity:
 * The current capacity of the drum.
 * <p>
 * - balance:
 * The current balance of the drum.
 * <p>
 * - litersOfWater:
 * The current amount of water in the drum in liters.
 * <p>
 * Constructor:
 * - The constructor calls the setDefaultValue method to initialize the properties.
 * <p>
 * Methods:
 * <p>
 * - Balancing:
 * Sets the balance of the drum to 0.
 * <p>
 * - setDefaultValue:
 * Sets the default values for the properties.
 * It sets the status to OK, and the capacity to 0.
 * <p>
 *
 * @see CheckAbleComponent
 * @see ComponentStatus
 */
@Data
public class Drum implements CheckAbleComponent {
    private ComponentStatus status;
    private int capacity;
    private int balance;
    private int litersOfWater;
    private int spinningSpeed;


    public Drum() {
        setDefaultValue();
    }

    public void Balancing() {
        this.balance = 0;
    }

    @Override
    public void setDefaultValue() {
        this.status = ComponentStatus.OK;
        this.capacity = 0;
    }
}
