package net.company.shape;

import net.company.UTUtil;
import net.company.shape.exception.InvalidShapeException;
import net.company.shape.impl.Rectangle;
import net.company.visitor.impl.AreaVisitor;
import org.junit.Before;
import org.junit.Test;

import static java.lang.StrictMath.abs;
import static junit.framework.TestCase.assertTrue;

/**
 * Test cases for {@link Rectangle}
 */
public class RectangleTest {
    private Rectangle rectangle;
    private AreaVisitor visitor;

    @Before
    public void setup() throws Exception {
        rectangle = new Rectangle(1, 2);
        visitor = new AreaVisitor();
    }

    @Test
    public void testRectangle() throws Exception {
        assertTrue(abs(2 - rectangle.calculateArea()) < UTUtil.MAX_DIFF);
    }

    @Test
    public void testAcceptVisitor() {
        rectangle.accept(visitor);

        assertTrue(abs(1 * 2 - visitor.getTotalArea()) < UTUtil.MAX_DIFF);
    }

    @Test(expected = NullPointerException.class)
    public void testAcceptNullVisitor() {
        rectangle.accept(null);
    }

    @Test(expected = InvalidShapeException.class)
    public void testRectangleWithInvalidLength() throws Exception {
        new Rectangle(0, 1);
    }

    @Test(expected = InvalidShapeException.class)
    public void testRectangleWithInvalidWidth() throws Exception {
        new Rectangle(10, -1);
    }
}
