package tests;

import com.javaclass.Dimension;
import com.javaclass.NumberDimension;
import org.junit.Test;
import static org.junit.Assert.*;


public class NumberDimensionTest {
    @Test
    public void plusTest() {
        /*
        подкорректировать регекс
        если вместо размерности написан бред - кидать эксепшн
        разные размерности - кидать эксепшн
         */
        NumberDimension a = new NumberDimension(1, "г");
        NumberDimension b = new NumberDimension(20, "кг");
        NumberDimension str1 = new NumberDimension("1 г");
        NumberDimension str2 = new NumberDimension("20 кг");
        NumberDimension c = new NumberDimension(1, "qw");
        NumberDimension d = new NumberDimension(2, "qw");

        assertEquals(new NumberDimension(20.001, "кг"), a.toSI().plus(b.toSI()));
        assertEquals(new NumberFormatException("Invalid dimension"), c.plus(d));
        assertEquals(new NumberDimension("20.001 кг"), str1.toSI().plus(str2.toSI()));
        assertEquals(new NumberFormatException("Different dimensions"), a.plus(b));
        assertEquals(new NumberFormatException("Different dimensions"), str1.plus(str2));
    }

    @Test
    public void minusTest() {
        NumberDimension expected = new NumberDimension(10, "кг");
        NumberDimension a = new NumberDimension(10, "кг");
        NumberDimension b = new NumberDimension(20, "кг");
        NumberDimension str1 = new NumberDimension("10 кг");
        NumberDimension str2 = new NumberDimension("20 кг");
        NumberDimension expectedStr = new NumberDimension("10 кг");

        NumberDimension result = b.minus(a);
        NumberDimension resultStr = str2.minus(str1);
        assertEquals(expected, result);
        assertEquals(expectedStr, resultStr);
    }

    @Test
    public void multiplyTest() {
        NumberDimension expected = new NumberDimension(20, "кг");
        NumberDimension a = new NumberDimension(10, "кг");
        NumberDimension str1 = new NumberDimension("10 кг");
        NumberDimension expectedStr = new NumberDimension("20 кг");

        NumberDimension result = a.multiply(2);
        NumberDimension resultStr = str1.multiply(2);
        assertEquals(expected, result);
        assertEquals(expectedStr, resultStr);
    }

    @Test
    public void divideTest() {
        NumberDimension expected = new NumberDimension(2, "кг");
        NumberDimension a = new NumberDimension(10, "кг");
        NumberDimension b = new NumberDimension(20, "кг");
        NumberDimension str1 = new NumberDimension("10 кг");
        NumberDimension str2 = new NumberDimension("20 кг");
        NumberDimension expectedStr = new NumberDimension("2 кг");

        NumberDimension result = b.divide(a);
        NumberDimension resultStr = b.divide(a);
        assertEquals(expected, result);
        assertEquals(expectedStr, resultStr);
    }


    /*@Test
    public void toSITest() {
        Dimension a = new Dimension(1000, "г");
        Dimension b = new Dimension(1, "h");
        Dimension aStr = new Dimension("1000 г");
        Dimension bStr = new Dimension("1 h");
        Dimension resultA = a.toSI();
        Dimension resultB = b.toSI();
        Dimension resultAStr = aStr.toSI();
        Dimension resultBStr = bStr.toSI();
        Dimension expectedA = new Dimension(1, "кг");
        Dimension expectedB = new Dimension(3600,"s");
        Dimension expectedAStr = new Dimension("1 кг");
        Dimension expectedBStr = new Dimension("3600 s");

        assertEquals(expectedA, resultA);
        assertEquals(expectedB, resultB);
        assertEquals(expectedAStr, resultAStr);
        assertEquals(expectedBStr, resultBStr);
    }*/

}
