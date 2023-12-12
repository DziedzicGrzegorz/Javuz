package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import lombok.Data;

@Data
public class DetergentContainer implements CheckAbleComponent {
    private ComponentStatus status;
    private int fabricSoftenerLevel;
    private int laundryDetergentLevel;

    public DetergentContainer() {
        setDefaultValue();
    }

    public void setDefaultValue() {
        this.status = ComponentStatus.OK;
        this.fabricSoftenerLevel = 0;
        this.laundryDetergentLevel = 0;
    }
}
