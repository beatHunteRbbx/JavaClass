package com.javaclass;

//использовать Dimension, а не строку.
//дать возможность пользователю хранить в конструкторе не строку а объект Dimension.
//создать еще один конструктор в который будет поступать объект Dimension.
import java.util.Objects;
import com.javaclass.Dimension;

public class NumberDimension {

    private final double number;
    private final String dimension;

    private String foolCheck(String str) {
        if (str.matches("\\s*\\d+\\s+(\\w|[а-яA-Я]){1,3}\\s*")) {
            String userString = str.replaceAll("\\s+", " ").trim();
            return userString;
        }
        else return "invalid";
    }

    private double getNumber() { return number; }
    private String getDimension() { return dimension; }

    public NumberDimension(double userNumber, String userDimension) {
        number = userNumber;
        dimension = userDimension;
    }


    public NumberDimension(String userStr) {
        if (!foolCheck(userStr).equals("invalid")) {
            number = Integer.parseInt(userStr.split(" ")[0]);
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
    public NumberDimension plus(NumberDimension other) {
        double number1 = getNumber();
        double number2 = other.getNumber();
        double numberResult = number1 + number2;
        return new NumberDimension(numberResult, dimension);
    }

    public NumberDimension minus(NumberDimension other) {
        double number1 = getNumber();
        double number2 = other.getNumber();
        double numberResult = number1 - number2;
        return new NumberDimension(numberResult, dimension);
    }

    public NumberDimension multiply(NumberDimension other) {
        double number1 = getNumber();
        double number2 = other.getNumber();
        double numberResult = number1 * number2;
        return new NumberDimension(numberResult, dimension);
    }

    public NumberDimension divide(NumberDimension other) {
        double number1 = getNumber();
        double number2 = other.getNumber();
        double numberResult = number1 / number2;
        return new NumberDimension(numberResult, dimension);
    }

    public boolean equal(NumberDimension other) {
        double number1 = getNumber();
        double number2 = other.getNumber();
        return number1 == number2;
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


    /* Класс будет использоваться примерно так:
    NumberDimension a = new NumberDimension(10, "кг");
    NumberDimension b = new NumberDimension(20, "кг");
    NumberDimension c = a.plus(b);

    На выходе должно получиться: c = new NumberDimension(30, "кг");

    Каждую операцию сделать как отдельный метод.

    пример метода:
    public static Number plus (Number other) {

    }

    перевод в систему си убрать. учитывание языка и регистра убрать. при неправильном вводе кидать эксепшн.
     */

    /*private static String foolCheck(String str) {
        if (str.matches("\\s*\\d+\\s+(\\w|[а-яA-Я]){1,3}\\s+(\\+|\\-|\\*|/|=)?\\s+\\d+\\s+(\\w|[а-яА-Я]){1,3}\\s*")) {
            String userString = str.replaceAll("\\s+", " ").trim();
            return userString;
        }
        else return "invalid";
    }
    public static String calculator(String str) {
        String[] userString = foolCheck(str).replaceAll("\\s+", " ").trim().split(" ");
        if (userString.length == 1) return "Invalid input! Try again. Example (only with spaces!): 1 km + 1 cm";
        else {
            int userNumber1 = Integer.parseInt(userString[0]);
            String userDimension1 = userString[1];
            String sign = userString[2];
            int userNumber2 = Integer.parseInt(userString[3]);
            String userDimension2 = userString[4];
            Dimension dimension = new Dimension();
            String summa = dimension.operation(userNumber1, userDimension1, sign, userNumber2, userDimension2);
            return summa;
        }
    }
    public static void main(String[] args) {
        System.out.println(calculator("1   d    + 1      s    "));
        System.out.println("Example: 1 cm + 2 km");
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
        dimension.operation("");
    }
    */


}
