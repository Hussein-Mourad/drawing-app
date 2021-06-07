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

    @Override
    public void draw(Graphics2D g2D) {
        diameter = (int) Math.abs(bottomCornerPosition.getX() - topCornerPosition.getX());
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);
        g2D.drawOval(getDrawX(), getDrawY(), diameter, diameter);
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
