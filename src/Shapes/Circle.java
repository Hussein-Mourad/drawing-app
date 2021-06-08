/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

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
    private Point center;

    public Circle(Point topCornerPosition, Point bottomCornerPosition) {
        super(topCornerPosition, bottomCornerPosition);
    }

    public Circle(Point topCornerPosition, Point bottomCornerPosition, float stroke) {
        super(topCornerPosition, bottomCornerPosition, stroke);
    }

    public Circle(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color) {
        super(topCornerPosition, bottomCornerPosition, stroke, color);
    }

    @Override
    public void draw(Graphics2D g2D) {
        diameter = Math.abs(bottomCornerPosition.x - topCornerPosition.x);
        center = new Point(
                bottomCornerPosition.x - topCornerPosition.x,
                bottomCornerPosition.y - topCornerPosition.y
        );
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);
        Ellipse2D.Float circle = new Ellipse2D.Float(getDrawX(), getDrawY(), diameter, diameter);
        g2D.draw(circle);
//        g2D.drawOval(getDrawX(), getDrawY(), diameter, diameter);
    }

    @Override
    public boolean isMouseInside(Point mousePosition) {

//        if () {
//            if (mousePosition.x >= topCornerPosition.x
//                    && mousePosition.x <= bottomCornerPosition.x
//                    && mousePosition.y >= topCornerPosition.y
//                    && mousePosition.y <= bottomCornerPosition.y) {
//                return true;
//            }
//        }
        return false;
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
