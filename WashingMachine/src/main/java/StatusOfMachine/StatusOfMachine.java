package StatusOfMachine;

import lombok.Getter;

@Getter
public enum StatusOfMachine {
    OK,
    OFF,
    STOPPED,
    ERROR,
    SERVICE_NEEDED;
}
