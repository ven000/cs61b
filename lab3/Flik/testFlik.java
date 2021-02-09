import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testFlik {

    @Test
    public void testFlik() {
        int a = 500;
        int b = 500;
        boolean c = false;
        assertEquals(c, Flik.isSameNumber(a, b));
    }
}