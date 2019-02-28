package tests;

import com.javaclass.NumberDimension;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class NumberDimensionTest {
    @Test
    public void plusTest() {
        NumberDimension a = new NumberDimension(10, "кг");
        NumberDimension b = new NumberDimension(20, "кг");
        int c = a.plus(b);
        assertEquals(30, c);
    }


}
