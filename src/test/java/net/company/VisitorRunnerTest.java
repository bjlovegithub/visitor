package net.company;

import net.company.shape.Shape;
import org.junit.Test;

import java.util.List;

import static java.lang.StrictMath.abs;
import static junit.framework.TestCase.assertTrue;

/**
 * Test cases for {@link VisitorRunner}
 */
public class VisitorRunnerTest {
    @Test(expected = RuntimeException.class)
    public void testRunnerWithZeroOrLessShapes() {
        new VisitorRunner(0, 0);
    }

    @Test(expected = RuntimeException.class)
    public void testRunnerWithNegativeMaxSize() {
        new VisitorRunner(1, 0);
    }

    @Test
    public void testRunWithSeveralShapes() {
        VisitorRunner runner = new VisitorRunner(6, 6);

        double totalAreaFromRunner = runner.calculateArea();

        double totalAreaFromAllShapes = 0F;
        List<Shape> shapeList = runner.getShapes();
        for (Shape shape : shapeList) {
            totalAreaFromAllShapes += shape.calculateArea();
        }

        assertTrue(abs(totalAreaFromAllShapes - totalAreaFromRunner) < UTUtil.MAX_DIFF);
    }
}
