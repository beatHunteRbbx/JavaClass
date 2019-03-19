package tests;

import com.javaclass.NumberDimension;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;



public class NumberDimensionTest {

    void assertEquals(NumberDimension expected, NumberDimension actual, double delta) {
        // ...
    }

    @Test
    public void plusTest() {
        NumberDimension a = new NumberDimension(1, "Г");
        NumberDimension b = new NumberDimension(20, "Кг");
        NumberDimension str1 = new NumberDimension("1 h");
        NumberDimension str2 = new NumberDimension("20 min");
        NumberDimension d = new NumberDimension(2, "qw");
        NumberDimension c = new NumberDimension(1, "qw");

        assertEquals(new NumberDimension(20.001, "кг"), a.toSI().plus(b.toSI()));
        assertEquals(new NumberDimension("4800 s"), str1.toSI().plus(str2.toSI()));

        Assertions.assertThrows(NumberFormatException.class, () -> c.toSI().plus(b.toSI()));
    }


    @Test
    public void minusTest() {
        NumberDimension a = new NumberDimension(1, "Г");
        NumberDimension b = new NumberDimension(20, "Кг");
        NumberDimension str1 = new NumberDimension("20 mIn");
        NumberDimension str2 = new NumberDimension("1 h");
        NumberDimension d = new NumberDimension(2, "qw");
        NumberDimension c = new NumberDimension(1, "qw");

        assertEquals(new NumberDimension(19.999, "кг"), b.toSI().minus(a.toSI()), 0.001);
        assertEquals(new NumberDimension("2400 s"), str2.toSI().minus(str1.toSI()));

        Assertions.assertThrows(NumberFormatException.class, () -> c.toSI().minus(b.toSI()));
    }

    @Test
    public void multiplyTest() {
        NumberDimension a = new NumberDimension(10, "г");
        NumberDimension str1 = new NumberDimension("1 h");
        NumberDimension d = new NumberDimension(2, "qw");

        assertEquals(new NumberDimension(0.02, "кг"), a.toSI().multiply(2));
        assertEquals(new NumberDimension("7200 s"), str1.toSI().multiply(2));

        Assertions.assertThrows(NumberFormatException.class, () -> d.toSI().multiply(2));
    }

    @Test
    public void divideTest() {

        NumberDimension a = new NumberDimension(2, "г");
        NumberDimension b = new NumberDimension(2, "кг");
        NumberDimension str1 = new NumberDimension("2 г");
        NumberDimension str2 = new NumberDimension("2 кг");
        NumberDimension d = new NumberDimension(2, "qw");
        NumberDimension c = new NumberDimension(1, "qw");

        assertEquals(1000, b.toSI().divide(a.toSI()), 1e-10);
        assertEquals(1000, str2.toSI().divide(str1.toSI()), 1e-10);
        assertEquals(new NumberDimension(1, "кг"), b.divide(2));
        assertEquals(new NumberDimension(1, "кг"), b.toSI().divide(2.0));
        assertEquals(new NumberDimension("1 кг"), str2.divide(2));
        assertEquals(new NumberDimension("1 кг"), str2.divide(2.0));

        Assertions.assertThrows(NumberFormatException.class, () -> c.toSI().divide(2));
        Assertions.assertThrows(NumberFormatException.class, () -> c.toSI().divide(b.toSI()));
    }

    @Test
    public void toSITest() {
        NumberDimension a = new NumberDimension(1000, "г");
        NumberDimension b = new NumberDimension(1, "h");
        NumberDimension aStr = new NumberDimension("1000 г");
        NumberDimension bStr = new NumberDimension("1 h");

        assertEquals(new NumberDimension(1, "кг"), a.toSI());
        assertEquals(new NumberDimension(3600,"s"), b.toSI());
        assertEquals(new NumberDimension("1 кг"), aStr.toSI());
        assertEquals(new NumberDimension("3600 s"), bStr.toSI());
    }

}
