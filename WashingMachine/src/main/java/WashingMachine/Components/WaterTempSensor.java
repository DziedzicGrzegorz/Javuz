package WashingMachine.Components;

import lombok.Data;

@Data
public class WaterTempSensor implements CheckAbleComponent {
    private ComponentStatus status;
    private int waterTemperature;

    public WaterTempSensor() {
        setDefaultValue();
    }

    @Override
    public void setDefaultValue() {
        this.status = ComponentStatus.OK;
        this.waterTemperature = 0;
    }
}
