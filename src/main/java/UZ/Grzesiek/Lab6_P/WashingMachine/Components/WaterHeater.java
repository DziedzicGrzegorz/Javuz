package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WaterHeater implements CheckableComponent {
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
