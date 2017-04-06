package net.company.shape;

import net.company.UTUtil;
import net.company.shape.exception.InvalidShapeException;
import net.company.shape.impl.Triangle;
import net.company.visitor.impl.AreaVisitor;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Math.abs;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for {@link Triangle}
 */
public class TriangleTest {
    private Triangle triangle;
    private AreaVisitor visitor;

    @Before
    public void setup() throws Exception {
        triangle = new Triangle(2, 2, 3);
        visitor = new AreaVisitor();
    }

    @Test
    public void testTriangle() throws Exception {
        assertTrue(abs(Util.triangleArea(2, 2, 3) - triangle.calculateArea()) < UTUtil.MAX_DIFF);
    }

    @Test
    public void testAcceptVisitor() {
        triangle.accept(visitor);

        assertTrue(abs(Util.triangleArea(2, 2, 3) - visitor.getTotalArea()) < UTUtil.MAX_DIFF);
    }

    @Test(expected = NullPointerException.class)
    public void testAcceptNullVisitor() {
        triangle.accept(null);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateTriangleWithInvalidLeftEdge() throws Exception {
        new Triangle(0, 1, 1);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateTriangleWithInvalidRightEdge() throws Exception {
        new Triangle(1, -1, 1);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateTriangleWithInvalidBottomEdge() throws Exception {
        new Triangle(1, 1, -1);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateTriangleWithBottomTooLong() throws Exception {
        new Triangle(1, 2, 3);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateTriangleWithRightEdgeTooLong() throws Exception {
        new Triangle(2, 3, 1);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateTriangleWithLeftEdgeTooLong() throws Exception {
        new Triangle(3, 2, 1);
    }
}
