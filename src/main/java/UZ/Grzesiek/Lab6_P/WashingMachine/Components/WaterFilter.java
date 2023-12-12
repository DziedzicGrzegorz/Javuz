package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import lombok.Data;

@Data
public class WaterFilter implements CheckAbleComponent {
    private ComponentStatus status;
    private int LevelOfPollution;

    public WaterFilter() {
        setDefaultValue();
    }

    @Override
    public void setDefaultValue() {
        this.status = ComponentStatus.OK;
        this.LevelOfPollution = 0;

    }
}
