import com.javaclass.Dimension;
import com.javaclass.NumberDimension;


public class Main {
    public static void main(String[] args) {
        NumberDimension a = new NumberDimension(10, "кг");
        NumberDimension b = new NumberDimension(20, "кг");

        System.out.println(b.getClassNumber());
    }
}