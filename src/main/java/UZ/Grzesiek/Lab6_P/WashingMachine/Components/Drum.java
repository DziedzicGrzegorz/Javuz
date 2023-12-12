package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import lombok.Data;

@Data
public class Drum {

    private ComponentStatus status;
    private int capacity;
    private int balance;
    public Drum() {
        this.status = ComponentStatus.OK;
        this.capacity = 0;
    }
    public void Balancing() {
        this.balance = 0;
    }
}
