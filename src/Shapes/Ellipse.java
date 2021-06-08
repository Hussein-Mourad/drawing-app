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
public class Ellipse extends Shape {

    private int width;
    private int height;

    public Ellipse(Point topCornerPosition, Point bottomCornerPosition) {
        super(topCornerPosition, bottomCornerPosition);
    }

    public Ellipse(Point topCornerPosition, Point bottomCornerPosition, float stroke) {
        super(topCornerPosition, bottomCornerPosition, stroke);
    }

    public Ellipse(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color) {
        super(topCornerPosition, bottomCornerPosition, stroke, color);
    }

    @Override
    public void draw(Graphics2D g2D) {
        width = Math.abs((bottomCornerPosition.x - topCornerPosition.x));
        height = Math.abs((bottomCornerPosition.y- topCornerPosition.y));
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);
        g2D.drawOval(getDrawX(), getDrawY(), width, height);
    }
}
