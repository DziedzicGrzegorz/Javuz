package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DetergentContainer implements CheckableComponent {
    public static void main(String[] args) {
        DetergentContainer test = new DetergentContainer();
    }

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
