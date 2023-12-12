package UZ.Grzesiek.Lab6_P.WashingMachine.Components;

import UZ.Grzesiek.Lab6_P.WashingMachine.Components.ComponentStatus;

public interface CheckableComponent {
    ComponentStatus getStatus();
    void setDefaultValue();
}
