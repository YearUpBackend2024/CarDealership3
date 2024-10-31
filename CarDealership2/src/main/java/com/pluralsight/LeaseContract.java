package com.pluralsight;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double LeaseFee;
    private double monthlyPayment;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold,
                         double totalPrice, double monthlyPayment, double expectedEndingValue, double leaseFee) {
        super(dateOfContract, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.expectedEndingValue = expectedEndingValue;
        this.LeaseFee = leaseFee;
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
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
