package net.company.shape;

import net.company.UTUtil;
import org.junit.Test;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for {@link Util}
 */
public class UtilTest {
    @Test
    public void testCircleArea() {
        assertTrue(abs(2 * 2 * PI - Util.circleArea(2)) < UTUtil.MAX_DIFF);
    }

    @Test
    public void testTriangleArea() {
        double mid = (1.0 + 1.0 + 1.0) / 2;

        assertTrue(abs(sqrt(mid * (mid - 1) * (mid - 1) * (mid - 1)) - Util.triangleArea(1, 1, 1)) < UTUtil.MAX_DIFF);
    }
}
