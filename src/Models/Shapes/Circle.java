/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author hussein
 */
public class Circle extends Ellipse {

    private int diameter;

    public Circle(Point topCornerPosition, Point bottomCornerPosition) {
        super(topCornerPosition, bottomCornerPosition);
    }

    public Circle(Point topCornerPosition, Point bottomCornerPosition, float stroke) {
        super(topCornerPosition, bottomCornerPosition, stroke);
    }

    public Circle(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color) {
        super(topCornerPosition, bottomCornerPosition, stroke, color);
    }

    public Circle(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color, boolean fill) {
        super(topCornerPosition, bottomCornerPosition, stroke, color, fill);
    }

    public Circle(Circle copy, Point mousePosition) { // copy constructor
        super(copy, mousePosition);
        this.diameter = copy.diameter;
    }

    @Override
    public void draw(Graphics2D g2D) {
        diameter = Math.abs(bottomCornerPosition.x - topCornerPosition.x);

        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);

        super.ellipse = new Ellipse2D.Float(getDrawX(), getDrawY(), diameter, diameter);

        if (fill) {
            g2D.fill(super.ellipse);
        } else {
            g2D.draw(super.ellipse);
        }
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        if (diameter > 0) {
            this.diameter = diameter;
        }
    }

}
