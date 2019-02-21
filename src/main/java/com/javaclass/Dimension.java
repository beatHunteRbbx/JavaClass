package com.javaclass;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Dimension {

    public double SI (String dimension, double number) {
        switch (dimension) {
            case "km": case "км":
                number *= 1000.0;
                break;
            case "s": case "с": case "m": case "м":
                number *= 1.0;
                break;
            case "dm": case "дм":
                number *= 0.1;
                break;
            case "cm": case "см":
                number *= 0.01;
                break;
            case "ms": case "мс": case "mm": case "мм":
                number *= 0.001;
                break;
            case "mks": case "мкс": case "mkm": case "мкм":
                number *= 0.000001;
                break;
            case "ns": case "нс": case "nm": case "нм":
                number *= 0.000000001;
        }
        return number;
    }
    public double operation(double number1, String dimension1, String sign, double number2, String dimension2) {
        number1 = SI(dimension1, number1);
        number2 = SI(dimension2, number2);
        double result = 0;
            switch (sign) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
                default:
                    System.out.println("Invalid operation.");
        }
        return result;
    }
}
