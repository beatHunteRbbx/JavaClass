package com.javaclass;


import java.util.Objects;

public class NumberDimension {

    private final int number;
    private final String dimension;

    public int getNumber() { return number; }

    public NumberDimension(int userNumber, String userDimension) {      //constructor
        number = userNumber;
        dimension = userDimension;
    }

    public NumberDimension plus(NumberDimension other) {
        int number1 = getNumber();
        int number2 = other.getNumber();
        int numberResult = number1 + number2;
        return new NumberDimension(numberResult, dimension);
    }

    public NumberDimension minus(NumberDimension other) {
        int number1 = getNumber();
        int number2 = other.getNumber();
        int numberResult = number1 - number2;
        return new NumberDimension(numberResult, dimension);
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
