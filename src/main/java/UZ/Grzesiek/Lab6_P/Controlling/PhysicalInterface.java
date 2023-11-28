package UZ.Grzesiek.Lab6_P.Controlling;

import UZ.Grzesiek.Lab6_P.StatusOfMachine.StatusOfMachine;

public interface PhysicalInterface{

    StatusOfMachine pumpWater();
    StatusOfMachine heatWater(int tempToAssign);
    StatusOfMachine balanceDrumContents();
}
