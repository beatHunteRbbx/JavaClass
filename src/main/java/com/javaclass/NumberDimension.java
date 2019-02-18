package com.javaclass;

import java.util.Scanner;

public class NumberDimension {

    public static String foolCheck(int number) {
        boolean rightInput = false;
        Scanner data = new Scanner(System.in);
        String userData = "";
        while (!rightInput) {
            System.out.print("Input " + number + " number with dimension: ");
            userData = data.nextLine();
            if (userData.matches("\\d+\\s+\\w{1,2}")) rightInput = true;
            else System.out.println("Incorrect input! Try again.");
        }
        return userData;
    }

    public static void main(String[] args) {
        String inputData1 = foolCheck(1);
        System.out.println("Example: 1 cm + 2 km");
        System.out.print("Input an expression as in the example: ");
        String userNumber1 = inputData1.split(" ")[0];
        String userDimension1 = inputData1.split(" ")[1];
        String inputData2 = foolCheck(2);
        String userNumber2 = inputData2.split(" ")[0];
        String userDimension2 = inputData2.split(" ")[1];
        System.out.print("What would you want to do?(+ - * /: ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        Dimension dimension = new Dimension();
        dimension.operation("");
    }
}
