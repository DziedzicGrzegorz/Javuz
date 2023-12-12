package UZ.Grzesiek.Lab6_P.WashingMachine.Components;


import lombok.Data;

@Data
public class WaterPump implements CheckableComponent {
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
