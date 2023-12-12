package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import lombok.Data;

@Data
public class WaterHeater implements CheckAbleComponent {
    private ComponentStatus status;
    private int levelOfDemotion;

    public WaterHeater() {
        setDefaultValue();
    }

    @Override
    public void setDefaultValue() {
        this.status = ComponentStatus.OK;
        this.levelOfDemotion = 0;
    }
}
