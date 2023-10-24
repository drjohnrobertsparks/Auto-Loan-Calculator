package org.johnrobertsparks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******************************************************");
        System.out.println(" ");
        System.out.println("          Welcome to the auto loan info center, ");
        System.out.println("              where we have a little fun ");
        System.out.println("  with numbers while informing you about your purchase. ");
        System.out.println(" ");
        System.out.println("********************************************************");

            //TODO fix ALL SOUT code so it doesn't accept less than zero

            //TODO fix ALL SOUT code so it doesn't accept an invalid input
            System.out.println("Please enter you loan amount: ");
            double loanAmount = scanner.nextDouble();
            if (loanAmount < 0){
                System.out.println("Please enter a positive number!");
            }

            System.out.println("Please enter your down payment amount: ");
            double downPayment = scanner.nextDouble();

            System.out.println("Please enter number of payments (How many months): ");
            int numberOfMonths = scanner.nextInt();

            System.out.println("Please enter your interest rate: ");
            double interestRate = scanner.nextDouble();

            Calculator loanCalculator = new Calculator(loanAmount, downPayment, numberOfMonths, interestRate);
            double monthlyPayment = loanCalculator.calculateMonthlyPayment();
            double interestPaid = (monthlyPayment * numberOfMonths) - (loanAmount - downPayment);
            double roundedInterestPaid = Calculator.roundToTwoPlaces(interestPaid);
            double amountPerThousand = (monthlyPayment * numberOfMonths) / 1000;
            double roundedAmountPerThousand = Calculator.roundToTwoPlaces((amountPerThousand));


            System.out.println("Your monthly payment on this loan would be: $" + loanCalculator.calculateMonthlyPayment());
            System.out.println(" ");
            System.out.println("The amount of interest paid on this loan would be: $ " + roundedInterestPaid);
            System.out.println(" ");
            System.out.println("With your current number of payments and interest rate,");
            System.out.println("you could expect your payment to increase or decrease");
            System.out.println("by " + roundedAmountPerThousand + " for each thousand dollar change.");
            System.out.println(" ");
            System.out.println("Happy shopping!");






    }
}
