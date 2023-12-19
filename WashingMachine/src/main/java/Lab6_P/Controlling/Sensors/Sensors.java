package Lab6_P.Controlling.Sensors;


import Lab6_P.StatusOfMachine.StatusOfMachine;
import Lab6_P.Utils.MSG;
import Lab6_P.Utils.SpecificComponentException;
import Lab6_P.WashingMachine.Components.*;
import Lab6_P.WashingMachine.WashingMachine;

import java.util.Arrays;
import java.util.List;

/**
 * The Sensors class implements the SensorsInterface and provides methods for checking the status of the components of a washing machine.
 * <p>
 * Properties:
 * - washingMachine: A reference to the WashingMachine instance that this class operates on.
 * <p>
 * Constructor:
 * - The constructor initializes the washingMachine property with the singleton instance of the WashingMachine class.
 * <p>
 * Methods:
 * <p>
 * - checkAllComponents:
 * Checks the status of all components of the washing machine.
 * It gets the components from the washing machine and calls the checkComponentStatus method for each component.
 * If an exception occurs during the operation, it throws the exception.
 * <p>
 * - checkComponentStatus:
 * Checks the status of a specific component of the washing machine.
 * It gets the status and name of the component, and prints a message indicating the status.
 * If the status is SERVICE_NEEDED, it sets the washing machine's status to SERVICE_NEEDED and prints a message.
 * If the status is ERROR, it throws a SpecificComponentException.
 * If an exception occurs during the operation, it prints an error message.
 * <p>
 *
 * @see WashingMachine
 * @see SensorsInterface
 */
public class Sensors implements SensorsInterface {
    private final WashingMachine washingMachine;

    public Sensors() {
        this.washingMachine = WashingMachine.getInstance();
    }

    public void checkAllComponents() throws Exception {
        List<CheckAbleComponent> components = Arrays.asList(
                washingMachine.getComponent(DetergentContainer.class),
                washingMachine.getComponent(Drum.class),
                washingMachine.getComponent(WaterFilter.class),
                washingMachine.getComponent(WaterHeater.class),
                washingMachine.getComponent(WaterPump.class)
        );

        for (CheckAbleComponent component : components) {
            checkComponentStatus(component);
        }
    }

    @Override
    public void checkComponentStatus(CheckAbleComponent component) throws Exception {
        ComponentStatus status = component.getStatus();
        String componentName = component.getClass().getSimpleName();

        try {
            MSG.print(STR."Checking \{componentName}...");
            Thread.sleep(1000);

            if (status == ComponentStatus.SERVICE_NEEDED) {
                MSG.print(STR."\{componentName} needs service!");
                washingMachine.setStatus(StatusOfMachine.SERVICE_NEEDED);
            } else if (status == ComponentStatus.ERROR) {
                throw new SpecificComponentException(STR."\{componentName} is broken!");
            }

            MSG.print(STR."\{componentName} is OK!");

        } catch (SpecificComponentException e) {
            throw e;
        } catch (Exception e) {
            MSG.print(STR."Something went wrong while checking \{componentName}!");
        }
    }
}