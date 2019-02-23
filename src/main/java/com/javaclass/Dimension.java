package com.javaclass;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;

public class Dimension {

    private double SI (String dimension, double number) {
        switch (dimension.toLowerCase()) {
            case "km": case "км":
                number *= 1000.0;
                break;
            case "s": case "с": case "m": case "м": case "kg": case "кг":
                number *= 1.0;
                break;
            case "dm": case "дм":
                number *= 0.1;
                break;
            case "cm": case "см":
                number *= 0.01;
                break;
            case "ms": case "мс": case "mm": case "мм": case "g": case "г":
                number *= 0.001;
                break;
            case "mks": case "мкс": case "mkm": case "мкм": case "mg": case "мг":
                number *= 0.000001;
                break;
            case "ns": case "нс": case "nm": case "нм":
                number *= 0.000000001;
            case "h": case "ч":
                number *= 3600.0;
                break;
            case "min": case "мин":
                number *= 60.0;
                break;
            case "d": case "д":
                number *= 86400.0;
                break;
        }
        return number;
    }
    private  String dimensionSI (String dimension) {
        if (dimension.toLowerCase().matches("km|m|dm|cm|mm|mkm|nm")) dimension = "m";
        else if (dimension.toLowerCase().matches("км|м|дм|см|мм|мкм|нм")) dimension = "м";
        else if (dimension.toLowerCase().matches("d|h|min|s|mc|mks|ns")) dimension = "s";
        else if (dimension.toLowerCase().matches("д|ч|мин|c|мс|мкс|нс")) dimension = "с";
        else if (dimension.toLowerCase().matches("кг|г|мг")) dimension = "кг";
        else if (dimension.toLowerCase().matches("kg|g|mg")) dimension = "kg";
        return dimension;
    }
    public String operation(double number1, String dimension1, String sign, double number2, String dimension2) {
        number1 = SI(dimension1, number1);
        number2 = SI(dimension2, number2);
        String answerDimension = "";
        double result = 0;
        boolean resultBool = false;
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
                case "=":
                    resultBool = number1 == number2;
                    break;
                default:
                    System.out.println("Invalid operation.");
        }
        dimension1 = dimensionSI(dimension1);
        dimension2 = dimensionSI(dimension2);
        if (dimension1.equals(dimension2)) answerDimension = dimension1;
        if (sign.equals("=")) {
            if (resultBool) return "Numbers are equals.";
            else return "Numbers are not equals.";
        }
        else return result + " " + answerDimension;
    }

    public String plus (double number1, String dimension1, String sign, double number2, String dimension2) {
        number1 = SI(dimension1, number1);
        number2 = SI(dimension2, number2);
        String answerDimension = "";
        double result = number1 - number2;
        dimension1 = dimensionSI(dimension1);
        dimension2 = dimensionSI(dimension2);
        if (dimension1.equals(dimension2)) answerDimension = dimension1;
        return result + " " + answerDimension;
    }
}
