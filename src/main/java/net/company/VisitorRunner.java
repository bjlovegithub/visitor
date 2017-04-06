package net.company;


import net.company.shape.Shape;
import net.company.shape.ShapeFactory;
import net.company.shape.exception.InvalidShapeException;
import net.company.visitor.impl.AreaVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * VisitorRunner will build some {@link Shape} randomly, and calculate the total area of all Shapes inside by
 * {@link VisitorRunner#calculateArea()}.
 */
public class VisitorRunner {
    /** Number of shapes */
    private final int numOfShapes;

    /** Max size of shapes. For circle, it refers to max radius; For Rectangle and Triangle, it refers to max length of edge */
    private final float maxSize;

    /** Keep all shapes in current runner */
    private final List<Shape> shapes;

    /** It will visit all shapes and accumulate their areas */
    private final AreaVisitor areaVisitor;

    private final Random random;

    /**
     * Construct a VisitorRunner.
     *
     * @param numOfShapes Number of shapes the runner will try to calculate their areas.
     * @param maxSize Max size of shapes. For circle, it refers to max radius;
     *                For Rectangle and Triangle, it refers to max length of edge
     */
    public VisitorRunner(int numOfShapes, float maxSize) {
        if (numOfShapes <= 0) {
            throw new RuntimeException("Number of shapes is less than 1.");
        }
        this.numOfShapes = numOfShapes;

        if (maxSize <= 0) {
            throw new RuntimeException("Size of shape is less than 1.");
        }
        this.maxSize = maxSize;

        this.random = new Random();

        // make different types of shapes randomly
        this.shapes = new ArrayList<>(numOfShapes);
        generateShapesRandomly();

        this.areaVisitor = new AreaVisitor();
    }

    public double calculateArea() {
        for (Shape shape : shapes) {
            shape.accept(areaVisitor);
        }

        return areaVisitor.getTotalArea();
    }

    List<Shape> getShapes() {
        return shapes;
    }

    // ------------------------------------------------------------------------
    // Utilities
    // ------------------------------------------------------------------------
    private void generateShapesRandomly() {
        Random random = new Random();
        for (int i = 0; i < numOfShapes; ++i) {
            int type = random.nextInt(ShapeFactory.getNumberOfShapeTypes());

            try {
                switch (type) {
                    case 0:
                        shapes.add(ShapeFactory.createCircle(generateNotZeroFloatRandomly()));
                        break;
                    case 1:
                        shapes.add(ShapeFactory.createRectangle(generateNotZeroFloatRandomly(), generateNotZeroFloatRandomly()));
                        break;
                    case 2:
                        float base = generateNotZeroFloatRandomly();
                        if ((base + 1) <= maxSize) {
                            shapes.add(ShapeFactory.createTriangle(base + 1, base + 1, base));
                        }
                        else {
                            shapes.add(ShapeFactory.createTriangle(base, base, base));
                        }
                        break;
                    default:
                        // do nothing
                        break;
                }
            }
            catch (InvalidShapeException e) {
                // it will never happen
                throw new RuntimeException("Fatal error while creating shapes: " + e);
            }
        }
    }

    private float generateNotZeroFloatRandomly() {
        float ret = 0F;

        while (ret <= 0) {
            ret = random.nextFloat() * maxSize;
        }

        return ret;
    }

    // ------------------------------------------------------------------------
    // Main
    // ------------------------------------------------------------------------
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error: number of shapes or max size missing");
            printUsage();
            System.exit(1);
        }

        // parse the parameters
        int num = 0;
        try {
            num = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e) {
            System.err.println("Error: The parameter number is not valid. Error: " + e);
            printUsage();
            System.exit(1);
        }
        float size = 0F;

        try {
            size = Float.parseFloat(args[1]);
        }
        catch (NumberFormatException e) {
            System.err.println("Error: The parameter max size is not valid. Error: " + e);
            printUsage();
            System.exit(1);
        }

        if (num <= 0 || size <= 0) {
            System.err.println("Error: Number of shapes or max size should be larger than zero.");
            printUsage();
            System.exit(1);
        }

        // calculate total area
        VisitorRunner runner = new VisitorRunner(num, size);
        for (Shape shape : runner.getShapes()) {
            System.out.println(shape.toString());
        }
        System.out.println("---\nTotal area: " + runner.calculateArea());
    }

    private static void printUsage() {
        System.out.println("Usage: VisitorRunner [number] [max size]");
        System.out.println("Parameters: ");
        System.out.println("\tnumber: Number of shapes.");
        System.out.println("\tmax size: Max size for a shape. For circle, it is max radius length; For rectangle and triangle, it is max edge length.");
    }
}
