package UZ.Lab1_P.Grzeg;

import java.util.Collections;
import java.util.TreeMap;

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

    public static void main(String[] args) {
        Zad6 temp = new Zad6();
        temp.countMonthlyInstallment(20, 0, 200_000);
    }

    public void displayInterestTable() {
        System.out.println(interestTable);
    }

    private int leasingInterestRate(int numberOfInstallments) throws IllegalArgumentException {
        if (numberOfInstallments > Collections.max(interestTable.keySet())) {
            throw new IllegalArgumentException("Months must be less than " + Collections.max(interestTable.keySet()));
        }

        int fullMonthsToCalcInterest = interestTable.ceilingKey(numberOfInstallments);
        System.out.println(interestTable.get(fullMonthsToCalcInterest));
        return interestTable.get(fullMonthsToCalcInterest);
    }

    public void countMonthlyInstallment(int numberOfInstallments, double paidInEquityCapital, double priceOfCar)  {
        this.countInstallmentGuard(paidInEquityCapital, priceOfCar);

        double remainingAmount = priceOfCar - paidInEquityCapital;
        double monthlyInterestRate = this.leasingInterestRate(numberOfInstallments) / 100.0 / 12.0;
        double installment = remainingAmount *
                monthlyInterestRate /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfInstallments));

        System.out.println(installment);
    }
    //this method is for checking if user can pay installment
    private void countInstallmentGuard(double paidInEquityCapital, double priceOfCar) throws IllegalArgumentException{
        if (paidInEquityCapital > maxPaidInEquityCapital) {
            throw new IllegalArgumentException("You can't pay more than " + maxPaidInEquityCapital);
        }
        if (paidInEquityCapital < 0) {
            throw new IllegalArgumentException("You can't pay less than 0");
        }
        if (priceOfCar <= 0) {
            throw new IllegalArgumentException("Price of car can't be less than 0");
        }
        //maxPercentageInEquityCapital*100 cast % to math value
        if (paidInEquityCapital > maxPercentageInEquityCapital * 100 * priceOfCar) {
            throw new IllegalArgumentException("Paid in equity capital can't be greater than " + maxPercentageInEquityCapital + " of price of car");
        }
    }

}