package net.company.visitor;

import net.company.shape.ShapeFactory;
import net.company.shape.Util;
import net.company.shape.impl.Circle;
import net.company.visitor.impl.AreaVisitor;
import org.junit.Test;

import static java.lang.StrictMath.abs;
import static junit.framework.TestCase.assertTrue;

/**
 * Test cases for {@link AreaVisitor}
 */
public class AreaVisitorTest {
    @Test
    public void testVisit() throws Exception {
        AreaVisitor visitor = new AreaVisitor();
        double totalArea = 0;

        // visit a rectangle
        visitor.visit(ShapeFactory.createRectangle(1, 1));

        totalArea += 1;
        assertTrue(abs(totalArea - visitor.getTotalArea()) < 0.001);

        // visit a circle
        visitor.visit(ShapeFactory.createCircle(2));

        totalArea += Util.circleArea(2);
        assertTrue(abs(totalArea - visitor.getTotalArea()) < 0.001);

        // visit a triangle
        visitor.visit(ShapeFactory.createTriangle(2, 2, 2));

        totalArea += Util.triangleArea(2, 2, 2);
        assertTrue(abs(totalArea - visitor.getTotalArea()) < 0.001);
    }

    @Test(expected = RuntimeException.class)
    public void testVisitWithNull() {
        AreaVisitor visitor = new AreaVisitor();

        visitor.visit((Circle) null);
    }
}
