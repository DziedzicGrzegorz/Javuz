package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import lombok.Data;

@Data
public class Drum implements CheckAbleComponent {
    private ComponentStatus status;
    private int capacity;
    private int balance;
    private int litersOfWater;

    public Drum() {
        setDefaultValue();
    }

    public void Balancing() {
        this.balance = 0;
    }

    @Override
    public void setDefaultValue() {
        this.status = ComponentStatus.OK;
        this.capacity = 0;
    }
}
