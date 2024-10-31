package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee1;
    private double processingFee2;
    private boolean wantToFinance;
    private double monthlyPayment;


    public SalesContract(String dateOfContract, String customerName, String customerEmail,
                         String vehicleSold, double totalPrice, double monthlyPayment) {
        super(dateOfContract, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee1 = processingFee1;
        this.processingFee2 = processingFee2;
        this.wantToFinance = wantToFinance;
        this.monthlyPayment = monthlyPayment;


    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee1() {
        return processingFee1;
    }

    public void setProcessingFee1(double processingFee1) {
        this.processingFee1 = processingFee1;
    }

    public double getProcessingFee2() {
        return processingFee2;
    }

    public void setProcessingFee2(double processingFee2) {
        this.processingFee2 = processingFee2;
    }

    public boolean isWantToFinance() {
        return wantToFinance;
    }

    public void setWantToFinance(boolean wantToFinance) {
        this.wantToFinance = wantToFinance;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        if (wantToFinance){
            salesTaxAmount = 0.05;
            recordingFee = 100;
            processingFee1 = 295;
            processingFee2 = 495;

        }
        return 0;
    }
}
