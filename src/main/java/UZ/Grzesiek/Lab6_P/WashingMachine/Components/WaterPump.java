package UZ.Grzesiek.Lab6_P.WashingMachine.Components;


import lombok.Data;

@Data
public class WaterPump {
    private ComponentStatus status;
    private int levelOfWater;

    public WaterPump() {
        this.status = ComponentStatus.OK;
        this.levelOfWater = 0;
    }

}
