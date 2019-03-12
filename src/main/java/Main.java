import com.javaclass.NumberDimension;


public class Main {
    public static void main(String[] args) {
        NumberDimension c = new NumberDimension(1, "qw");
        NumberDimension d = new NumberDimension(10, "qw");
        NumberDimension a = new NumberDimension(1, "г");
        NumberDimension b = new NumberDimension(20, "кг");

        System.out.println(c.plus(d));
    }
}
