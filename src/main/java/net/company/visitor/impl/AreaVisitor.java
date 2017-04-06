package net.company.visitor.impl;

import net.company.shape.impl.Circle;
import net.company.shape.impl.Rectangle;
import net.company.shape.impl.Triangle;
import net.company.visitor.Visitor;

/**
 * AreaVisitor is to calculate total area for all visited {@link net.company.shape.Shape}s.
 */
public class AreaVisitor implements Visitor {
    private double totalArea;

    public void visit(Circle circle) {
        totalArea += circle.calculateArea();
    }

    public void visit(Rectangle rectangle) {
        totalArea += rectangle.calculateArea();
    }

    public void visit(Triangle triangle) {
        totalArea += triangle.calculateArea();
    }

    public double getTotalArea() {
        return this.totalArea;
    }
}
