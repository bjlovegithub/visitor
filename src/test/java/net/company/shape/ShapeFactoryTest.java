package net.company.shape;

import net.company.shape.exception.InvalidShapeException;
import net.company.shape.impl.Circle;
import net.company.shape.impl.Rectangle;
import net.company.shape.impl.Triangle;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Test cases for {@link ShapeFactory}
 */
public class ShapeFactoryTest {
    @Test
    public void testCreateWithNormalParameters() throws Exception {
        assertTrue(ShapeFactory.createCircle(1) instanceof Circle);
        assertTrue(ShapeFactory.createRectangle(1, 2) instanceof Rectangle);
        assertTrue(ShapeFactory.createTriangle(2, 2, 3) instanceof Triangle);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateCircleWithInvalidRadius() throws Exception {
        ShapeFactory.createCircle(0);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateRectangleWithInvalidLength() throws Exception {
        ShapeFactory.createRectangle(-1, 10);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateRectangleWithInvalidWidth() throws Exception {
        ShapeFactory.createRectangle(10, 0);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateTriangleWithInvalidLeftEdge() throws Exception {
        ShapeFactory.createTriangle(0, 1, 1);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateTriangleWithInvalidRightEdge() throws Exception {
        ShapeFactory.createTriangle(1, -1, 1);
    }

    @Test(expected = InvalidShapeException.class)
    public void testCreateTriangleWithInvalidBottomEdge() throws Exception {
        ShapeFactory.createTriangle(1, 1, -1);
    }
}
