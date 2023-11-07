package UZ.Grzesiek.Lab1_P;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.TreeMap;

/**
 * This class represents a calculator for calculating monthly installments for leasing a car.
 */
public class Zad6 {
    static TreeMap<Integer, Integer> interestTable = new TreeMap<>() {{
        put(24, 2);
        put(48, 3);
        put(60, 4);
        put(72, 5);
        put(96, 6);
    }};
    final static double maxPaidInEquityCapital = 300_000.00;
    final static double maxPercentageInEquityCapital = 70;
    private double installment;


    public static void main(String[] args) {
        Zad6 temp = new Zad6(20, 0, 200_000);
    }

    Zad6(int numberOfInstallments, double paidInEquityCapital, double priceOfCar) {
        countMonthlyInstallment(numberOfInstallments, paidInEquityCapital, priceOfCar);
        printfInstallment();
    }

    private int leasingInterestRate(int numberOfInstallments) throws IllegalArgumentException {
        if (numberOfInstallments > Collections.max(interestTable.keySet())) {
            throw new IllegalArgumentException(STR."Months must be less than \{Collections.max(interestTable.keySet())}");
        }
        /*
         * if userwant to pay 22 installments he will pay the same interest rate as for 24 installments
         *
         * */
        int fullMonthsToCalcInterest = interestTable.ceilingKey(numberOfInstallments);
        return interestTable.get(fullMonthsToCalcInterest);
    }

    public void countMonthlyInstallment(int numberOfInstallments, double paidInEquityCapital, double priceOfCar) {
        countInstallmentGuard(paidInEquityCapital, priceOfCar);
        // I don't even know how banks count this but Google knows
        double remainingAmount = priceOfCar - paidInEquityCapital;
        double monthlyInterestRate = leasingInterestRate(numberOfInstallments) / 100.0 / 12.0;
        installment = remainingAmount *
                monthlyInterestRate /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfInstallments));
    }

    //this method is for checking if user can pay installment
    private void countInstallmentGuard(double paidInEquityCapital, double priceOfCar) throws IllegalArgumentException {
        if (paidInEquityCapital > maxPaidInEquityCapital) {
            throw new IllegalArgumentException(STR."You can't pay more than \{maxPaidInEquityCapital}");
        }
        if (paidInEquityCapital < 0) {
            throw new IllegalArgumentException("You can't pay less than 0");
        }
        if (priceOfCar <= 0) {
            throw new IllegalArgumentException("Price of car can't be less than 0");
        }
        //maxPercentageInEquityCapital*100 cast % to math value
        if (paidInEquityCapital > maxPercentageInEquityCapital * 100 * priceOfCar) {
            throw new IllegalArgumentException(STR."Paid in equity capital can't be greater than \{maxPercentageInEquityCapital} of price of car");
        }
    }

    public void printfInstallment() {
        BigDecimal roundInstallment = new BigDecimal(installment).setScale(2, RoundingMode.CEILING);
        System.out.println(STR."Your installment is \{roundInstallment} PLN");
    }
}
