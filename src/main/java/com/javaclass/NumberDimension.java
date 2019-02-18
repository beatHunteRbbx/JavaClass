package com.javaclass;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Scanner;

public class NumberDimension {

    public static String foolCheck(String str) {
        if (str.matches("\\s*\\d+\\s*\\w{1,3}\\s*(\\+|\\-|\\*|\\\\){1}\\s*\\d+\\s*\\w{1,3}\\s*")) {
            String userString = str.replaceAll("\\s+", " ").trim();
            return userString;
        }
        else return "Invalid input! Try again. Example: 1 km + 1 cm";
    }
    public static int calculator(String str) {
        String[] userString = foolCheck(str).replaceAll("\\s+", " ").trim().split(" ");
        int userNumber1 = Integer.parseInt(userString[0]);
        String userDimension1 = userString[1];
        String operation = userString[2];
        int userNumber2 = Integer.parseInt(userString[3]);
        String userDimension2 = userString[4];
        return userNumber1 + userNumber2;
    }
    public static void main(String[] args) {

        System.out.println(calculator("1123   km     + 2                   cm          "));
        /*System.out.println("Example: 1 cm + 2 km");
        System.out.print("Input an expression as in the example: ");
        String inputData1 = foolCheck();
        String userNumber1 = inputData1.split(" ")[0].replace(" ","");
        String userDimension1 = inputData1.split(" ")[1];
        String inputData2 = foolCheck(2);
        String userNumber2 = inputData2.split(" ")[0];
        String userDimension2 = inputData2.split(" ")[1];
        System.out.print("What would you want to do?(+ - * /: ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        Dimension dimension = new Dimension();
        dimension.operation("");*/
    }
}
