package UZ.Grzesiek.Lab6_P.Controlling;

import UZ.Grzesiek.Lab6_P.StatusOfMachine;

public interface PhysicalInterface{

    StatusOfMachine pumpWater();
    StatusOfMachine heatWater(int tempToAssign);
    StatusOfMachine balanceDrumContents();
    StatusOfMachine checkFilter() throws InterruptedException;
}
