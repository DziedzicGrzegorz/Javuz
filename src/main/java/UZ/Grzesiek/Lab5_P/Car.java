package UZ.Grzesiek.Lab5_P;

import java.time.LocalDate;
import java.time.Period;

/**
 * The Car class represents a car with its attributes and functionality.
 */
public class Car {
    private String make;
    private String model;
    private int engineCapacity;
    private String bodyType;
    private String engineType;
    private int yearOfProduction;
    private LocalDate firstRegistrationDate;
    private double price;

    public static void main(String[] args) {
        Car test = new Car("BMW", "M3", 3000, "Sedan", "Petrol", 2019, LocalDate.of(2021, 2, 28), 100000);
        System.out.println(test.toString());
    }

    public Car() {
    }

    public Car(String make, String model, int engineCapacity, String bodyType, String engineType,
               int yearOfProduction, LocalDate firstRegistrationDate, double price) {
        this.make = make;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.bodyType = bodyType;
        this.engineType = engineType;
        this.yearOfProduction = yearOfProduction;
        this.firstRegistrationDate = firstRegistrationDate;
        this.price = price;
    }

    public String checkWarranty() {
        LocalDate nowInTime = LocalDate.now();
        Period periodBetweenFirstRegistrationAndNow = Period.between(firstRegistrationDate, nowInTime);


        if (periodBetweenFirstRegistrationAndNow.getYears() < 2) {
            return "The car still has warranty.";
        } else {
            return "The car doesn't have warranty.";
        }
    }

    @Override
    public String toString() {
        return STR."brand='\{make}',\nmodel='\{model}',\nengineCapacity=\{engineCapacity},\nbodyType='\{bodyType}',\nengineType='\{engineType}',\nyearOfProduction=\{yearOfProduction},\nfirstRegistrationDate=\{firstRegistrationDate},\nprice=\{price}'\n";
    }
}
