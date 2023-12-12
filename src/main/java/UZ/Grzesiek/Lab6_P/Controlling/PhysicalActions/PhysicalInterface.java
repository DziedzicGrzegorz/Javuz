package UZ.Grzesiek.Lab6_P.Controlling.PhysicalActions;

import UZ.Grzesiek.Lab6_P.StatusOfMachine.StatusOfMachine;

public interface PhysicalInterface {

    StatusOfMachine pumpInWater(int levelOfWater);

    StatusOfMachine pumpOutWater();

    StatusOfMachine heatWater(int tempToAssign);

    StatusOfMachine balanceDrumContents();

    StatusOfMachine addFabricSoftener(int amountOfSoftener);

    StatusOfMachine addLaundryDetergent(int amountOfDetergent);

    StatusOfMachine AfterWashingResetValues();
}
