package net.company.shape;

import net.company.UTUtil;
import net.company.shape.exception.InvalidShapeException;
import net.company.shape.impl.Circle;
import net.company.visitor.impl.AreaVisitor;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Math.PI;
import static java.lang.StrictMath.abs;
import static junit.framework.TestCase.assertTrue;

/**
 * Test cases for {@link Circle}
 */
public class CircleTest {
    private Circle circle;
    private AreaVisitor visitor;

    @Before
    public void setup() throws Exception {
        circle = new Circle(3);
        visitor = new AreaVisitor();
    }

    @Test
    public void testCircleWithValidRadius() throws Exception {
        Circle circle = new Circle(3);

        assertTrue(abs(PI * 3 * 3 - circle.calculateArea()) < UTUtil.MAX_DIFF);
    }

    @Test
    public void testAcceptVisitor() {
        circle.accept(visitor);

        assertTrue(abs(Util.circleArea(3) - visitor.getTotalArea()) < UTUtil.MAX_DIFF);
    }

    @Test(expected = NullPointerException.class)
    public void testAcceptNullVisitor() {
        circle.accept(null);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCircleWithInvalidRadius() throws Exception {
        new Circle(0);
    }
}
