package com.javaclass;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Dimension {
    public double operation(double number1, String dimension1, String sign, double number2, String dimension2) {
        HashMap<Pair<String, String>, Double> length = new HashMap<>();
        length.put(new Pair<>("km","км"), 1000.0);
        length.put(new Pair<>("m","м"), 1.0);
        length.put(new Pair<>("dm","дм"), 0.1);
        length.put(new Pair<>("cm","см"), 0.01);
        length.put(new Pair<>("mm","мм"), 0.001);
        length.put(new Pair<>("mkm","мкм"), 0.000001);
        length.put(new Pair<>("nm","нм"), 0.000000001);

        HashMap<Pair<String, String>, Double> time = new HashMap<>();
        time.put(new Pair<>("s","с"), 1.0);
        time.put(new Pair<>("ms","мс"), 0.001);
        time.put(new Pair<>("mks","мкс"), 0.000001);
        time.put(new Pair<>("ns","нс"), 0.000000001);

        double result = 0;
        if (dimension1.equals(dimension2)) {
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
        } else {
            switch (sign) {
                case "+":
                    //нужно как-то по паре достать значение из мапы
                    result = number1 * length.get(dimension1) + number2 * length.get(dimension1);
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
        }
        return result;
    }
}
