package com.javaclass;

import java.util.Objects;

public class NumberDimension {

    private final double number;
    private final String dimension;

    private boolean foolCheck(String str) { return str.matches("\\s*(\\d+|\\d+\\.\\d+)\\s+(\\w|[а-яA-Я]){1,3}\\s*"); }


    private double getNumber() { return number; }
    private String getDimension() { return dimension; }

    public NumberDimension(double userNumber, String userDimension) {
        number = userNumber;
        dimension = userDimension;
    }


    public NumberDimension(String userStr) {
        if (foolCheck(userStr)) {
            userStr = userStr.replaceAll("\\s+", " ").trim();
            number = Double.parseDouble(userStr.split(" ")[0]);
            dimension = userStr.split(" ")[1];
        }
        else throw new NumberFormatException("Invalid output!");
    }

    public final NumberDimension toSI() {
        double userNumber = getNumber();
        String userDimension = getDimension();

        switch (userDimension.toLowerCase()) {
            case "km": case "км":
                userNumber *= 1000.0;
                break;
            case "s": case "с": case "m": case "м": case "kg": case "кг":
                userNumber *= 1.0;
                break;
            case "dm": case "дм":
                userNumber *= 0.1;
                break;
            case "cm": case "см":
                userNumber *= 0.01;
                break;
            case "ms": case "мс": case "mm": case "мм": case "g": case "г":
                userNumber *= 0.001;
                break;
            case "mks": case "мкс": case "mkm": case "мкм": case "mg": case "мг":
                userNumber *= 0.000001;
                break;
            case "ns": case "нс": case "nm": case "нм":
                userNumber *= 0.000000001;
            case "h": case "ч":
                userNumber *= 3600.0;
                break;
            case "min": case "мин":
                userNumber *= 60.0;
                break;
            case "d": case "д":
                userNumber *= 86400.0;
                break;
             default: throw new NumberFormatException("Invalid dimension");
        }

        if (userDimension.toLowerCase().matches("km|m|dm|cm|mm|mkm|nm"))
            userDimension = "m";
        else if (userDimension.toLowerCase().matches("км|м|дм|см|мм|мкм|нм"))
            userDimension = "м";
        else if (userDimension.toLowerCase().matches("d|h|min|s|mc|mks|ns"))
            userDimension = "s";
        else if (userDimension.toLowerCase().matches("д|ч|мин|c|мс|мкс|нс"))
            userDimension = "с";
        else if (userDimension.toLowerCase().matches("кг|г|мг"))
            userDimension = "кг";
        else if (userDimension.toLowerCase().matches("kg|g|mg"))
            userDimension = "kg";

        return new NumberDimension(userNumber, userDimension);
    }
    public final NumberDimension plus(NumberDimension other) {
        if (!this.dimension.equals(other.dimension)) throw new IllegalArgumentException("Different dimensions");
        double number1 = getNumber();
        double number2 = other.getNumber();
        double numberResult = number1 + number2;
        return new NumberDimension(numberResult, dimension);
    }

    public final NumberDimension minus(NumberDimension other) {
        if (!this.dimension.equals(other.dimension)) throw new IllegalArgumentException("Different dimensions");
        double number1 = getNumber();
        double number2 = other.getNumber();
        double numberResult = number1 - number2;
        return new NumberDimension(numberResult, dimension);
    }

    public final NumberDimension multiply (double number) {
        double userNumber = getNumber();
        double numberResult = userNumber * number;
        return new NumberDimension(numberResult, dimension);
    }

    public final double divide(NumberDimension other) {
        if (!this.dimension.equals(other.dimension)) throw new IllegalArgumentException("Different dimensions");
        double number1 = getNumber();
        double number2 = other.getNumber();
        double numberResult = number1 / number2;
        return numberResult;
    }

    public final NumberDimension divide(double number) {
        double userNumber = getNumber();
        double numberResult = userNumber / number;
        return new NumberDimension(numberResult, dimension);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberDimension that = (NumberDimension) o;
        return number == that.number &&
                Objects.equals(dimension, that.dimension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, dimension);
    }

}
