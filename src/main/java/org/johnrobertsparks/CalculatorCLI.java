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

            System.out.println("Please enter you loan amount: ");
            double loanAmount = 0;
            boolean validInputLoan = false;
            while (!validInputLoan) {
                try {
                    loanAmount = scanner.nextDouble();
                    if (loanAmount < 0){
                        System.out.println("Please enter a positive number!");
                    } else {
                        validInputLoan = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number. " + e);
                    scanner.next();
                }

            }

            System.out.println("Please enter your down payment amount: ");
            double downPayment = 0;
            boolean validInputDownPayment = false;
            while (!validInputDownPayment){
                try{
                    downPayment = scanner.nextDouble();
                    if (downPayment < 0){
                        System.out.println("Please enter a positive number!");
                    } else if (downPayment > loanAmount){
                        System.out.println("Go pay cash for your vehicle! Have fun shopping!");
                        System.exit(0);
                    } else {
                        validInputDownPayment = true;
                    }
                } catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter a valid number. " + e);
                    scanner.next();
                }

            }

            System.out.println("Please enter number of payments (How many months): ");
            int numberOfMonths = 0;
            boolean validNumberOfPayments = false;
            while (!validNumberOfPayments){
                try {
                    numberOfMonths = scanner.nextInt();
                    if (numberOfMonths < 0){
                        System.out.println("Please enter a positive number whole number!");
                    } else {
                        validNumberOfPayments = true;
                    }
                } catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter a valid number. " + e);
                    scanner.next();
                }
            }

            System.out.println("Please enter your interest rate: ");
            double interestRate = 0;
            boolean rateOfInterest = false;
            while (!rateOfInterest){
                try{
                    interestRate = scanner.nextDouble();
                    if (interestRate < 0){
                        System.out.println("Please enter a positive number!");
                    } else {
                        rateOfInterest = true;
                    }
                } catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter a valid number. " + e);
                    scanner.next();
                }
            }


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
