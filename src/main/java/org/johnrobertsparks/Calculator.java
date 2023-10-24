package org.johnrobertsparks;

public class Calculator {
    private double loanAmount;
    private double downPayment;
    private double interestRate;
    private int numberOfMonths;

    public Calculator(double loanAmount, double downPayment, int numberOfMonths, double interestRate){
        this.loanAmount = loanAmount - downPayment;
        this.numberOfMonths = numberOfMonths;
        this.interestRate = interestRate / 100 / 12;

    }

    public double calculateMonthlyPayment(){
        double monthlyInterestRate = Math.pow(1 + interestRate, numberOfMonths);
        double result = (loanAmount * interestRate * monthlyInterestRate) / (monthlyInterestRate - 1);

        return roundToTwoPlaces(result);

    }

    public static double roundToTwoPlaces(double number) {
        return Math.round(number * 100.0) / 100.0; // round to two decimal places
    }



}
