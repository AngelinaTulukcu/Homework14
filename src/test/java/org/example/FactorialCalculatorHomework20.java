package org.example;

import java.util.Scanner;

public class FactorialCalculatorHomework20 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter an integer to calculate factorial: ");
            int number = scanner.nextInt();

            if (number < 0) {
                throw new IllegalArgumentException("Factorial is not defined for negative numbers");
            }

            long factorial = calculateFactorial(number);
            System.out.println("Factorial of a number " + number + " equals: " + factorial);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.err.println("Error: Invalid number entered");
        } finally {
            scanner.close();
        }
    }

    private static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            long factorial = 1;
            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }
}
