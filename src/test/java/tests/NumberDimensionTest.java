package tests;

import com.javaclass.NumberDimension;
import org.junit.Test;
import static org.junit.Assert.*;


public class NumberDimensionTest {
    @Test
    public void plusTest() {
        NumberDimension expected = new NumberDimension(30, "кг");
        NumberDimension a = new NumberDimension(10, "кг");
        NumberDimension b = new NumberDimension(20, "кг");
        NumberDimension str1 = new NumberDimension("10 кг");
        NumberDimension str2 = new NumberDimension("20 кг");
        NumberDimension expectedStr = new NumberDimension("30 кг");

        NumberDimension result = a.plus(b);
        NumberDimension resultStr = str1.plus(str2);
        assertEquals(expected, result);
        assertEquals(expectedStr, resultStr);
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
        NumberDimension expected = new NumberDimension(200, "кг");
        NumberDimension a = new NumberDimension(10, "кг");
        NumberDimension b = new NumberDimension(20, "кг");
        NumberDimension str1 = new NumberDimension("10 кг");
        NumberDimension str2 = new NumberDimension("20 кг");
        NumberDimension expectedStr = new NumberDimension("200 кг");

        NumberDimension result = a.multiply(b);
        NumberDimension resultStr = str1.multiply(str2);
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

    @Test
    public void equalTest() {
        NumberDimension a = new NumberDimension(10, "кг");
        NumberDimension b = new NumberDimension(20, "кг");
        NumberDimension str1 = new NumberDimension("20 кг");
        NumberDimension str2 = new NumberDimension("20 кг");

        boolean result = a.equal(b);
        boolean resultStr = str1.equal(str2);
        assertFalse(result);
        assertTrue(resultStr);
    }


}
