package com.pluralsight.contracts;

import com.pluralsight.BankingCalculations;
import com.pluralsight.Vehicle;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private final double expectedEndingValuePctOfPrice = 0.50;
    private double LeaseFee;
    private final double leaseFeePercentage = 0.07;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * expectedEndingValuePctOfPrice;
        this.LeaseFee = vehicleSold.getPrice() * leaseFeePercentage;
    }

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double expectedEndingValue, double leaseFee) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        LeaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return LeaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.LeaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return (this.expectedEndingValue + this.getLeaseFee());
    }

    @Override
    public double getMonthlyPayment() {
        double financeRate = 0.04;
        double financeTerm = 36;

        return BankingCalculations.calculateLoanPayment(this.getTotalPrice(), financeRate, financeTerm);
    }
}
