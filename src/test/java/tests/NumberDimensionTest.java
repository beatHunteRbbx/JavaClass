package tests;

import com.javaclass.NumberDimension;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;




public class NumberDimensionTest {

    private void assertApproximatelyEquals(NumberDimension expected, NumberDimension actual, double delta) {
        assertTrue(Math.abs(expected.getNumber() - actual.getNumber()) < delta);
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
        /*Assertions.assertThrows(NumberFormatException.class, () -> c.toSI().plus(b.toSI()));*/

    }


    @Test
    public void minusTest() {
        NumberDimension a = new NumberDimension(1.1, "кГ");
        NumberDimension b = new NumberDimension(20.2, "Кг");
        NumberDimension str1 = new NumberDimension("20 mIn");
        NumberDimension str2 = new NumberDimension("1 h");
        NumberDimension d = new NumberDimension(2, "qw");
        NumberDimension c = new NumberDimension(1, "qw");

        assertApproximatelyEquals(new NumberDimension(19.1, "кг"), b.toSI().minus(a.toSI()), 1e-10);
        assertApproximatelyEquals(new NumberDimension("2400 s"), str2.toSI().minus(str1.toSI()), 1e-10);

        /*Assertions.assertThrows(NumberFormatException.class, () -> c.toSI().minus(b.toSI()));*/
    }

    @Test
    public void multiplyTest() {
        NumberDimension a = new NumberDimension(10.1, "кг");
        NumberDimension str1 = new NumberDimension("1 h");
        NumberDimension d = new NumberDimension(2, "qw");

        assertApproximatelyEquals(new NumberDimension(22.2, "кг"), a.toSI().multiply(2.2), 1e-1);
        assertApproximatelyEquals(new NumberDimension("7200 s"), str1.toSI().multiply(2), 1e-10);

        /*Assertions.assertThrows(NumberFormatException.class, () -> d.toSI().multiply(2));*/
    }

    @Test
    public void divideTest() {

        NumberDimension a = new NumberDimension(2, "г");
        NumberDimension b = new NumberDimension(10.4, "кг");
        NumberDimension str1 = new NumberDimension("2 г");
        NumberDimension str2 = new NumberDimension("2 кг");
        NumberDimension d = new NumberDimension(2, "qw");
        NumberDimension c = new NumberDimension(1, "qw");

        assertEquals(5200, b.toSI().divide(a.toSI()), 1e-10);
        assertEquals(1000, str2.toSI().divide(str1.toSI()), 1e-10);
        assertApproximatelyEquals(new NumberDimension(2.04, "кг"), b.divide(5.1), 1e-3);
        assertApproximatelyEquals(new NumberDimension(5.0, "кг"), b.toSI().divide(2.1), 1e-1);
        assertEquals(new NumberDimension("1 кг"), str2.divide(2));
        assertEquals(new NumberDimension("1 кг"), str2.divide(2.0));

        /*Assertions.assertThrows(NumberFormatException.class, () -> c.toSI().divide(2));
        Assertions.assertThrows(NumberFormatException.class, () -> c.toSI().divide(b.toSI()));*/
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
