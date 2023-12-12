package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WaterHeater {
    private ComponentStatus status;
    private int levelOfDemotion;
    public WaterHeater() {
        this.status = ComponentStatus.OK;
        this.levelOfDemotion = 0;
    }

}
