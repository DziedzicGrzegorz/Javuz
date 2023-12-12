package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WaterFilter {
    private ComponentStatus status;
    private int LevelOfPollution;
    public WaterFilter() {
        this.status = ComponentStatus.OK;
        this.LevelOfPollution = 0;
    }
}
