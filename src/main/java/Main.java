import com.javaclass.Dimension;
import com.javaclass.NumberDimension;


public class Main {
    public static void main(String[] args) {
        Dimension c = new Dimension(1, "г");
        Dimension d = new Dimension(10, "кг");
        NumberDimension a = new NumberDimension(1, "г");
        NumberDimension b = new NumberDimension(20, "кг");
        NumberDimension res = a.plus(b);
        System.out.println(res);
    }
}
