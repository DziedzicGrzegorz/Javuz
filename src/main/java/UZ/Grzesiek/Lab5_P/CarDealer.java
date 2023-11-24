package UZ.Grzesiek.Lab5_P;

import java.time.LocalDate;
import java.util.ArrayList;

public class CarDealer {

    ArrayList<Car> arrayOfCars = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "M3", 3000, "Sedan", "Petrol", 2019,
                LocalDate.of(2021, 2, 28), 100000)
        );
        cars.add(new Car("BMW", "M3", 3000, "Sedan", "Petrol", 2019,
                LocalDate.of(2021, 2, 28), 100000));

        CarDealer carDealer = new CarDealer(cars);
        carDealer.displayCars();
    }

    CarDealer(ArrayList<Car> cars) {
        this.arrayOfCars = cars;
    }

    CarDealer() {
    }

    public void displayCars() {
        for (Car car : arrayOfCars) {
            System.out.println(car.toString());
        }
    }
}
