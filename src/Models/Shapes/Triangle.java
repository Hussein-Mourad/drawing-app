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

/**
 *
 * @author hussein
 */
public class Triangle extends Shape {

    private Point bottomCornerPosition2;

    public Triangle(Point topCornerPosition, Point bottomCornerPosition) {
        super(topCornerPosition, bottomCornerPosition);
    }

    public Triangle(Point topCornerPosition, Point bottomCornerPosition, float stroke) {
        super(topCornerPosition, bottomCornerPosition, stroke);
    }

    public Triangle(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color) {
        super(topCornerPosition, bottomCornerPosition, stroke, color);
    }

    public Triangle(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color, boolean fill) {
        super(topCornerPosition, bottomCornerPosition, stroke, color, fill);
    }

    public Triangle(Triangle copy) { // copy constructor
        super(copy);
        this.bottomCornerPosition2 = copy.bottomCornerPosition2;
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);
        int x = (topCornerPosition.x - (bottomCornerPosition.x - topCornerPosition.x));
        int y = bottomCornerPosition.y;
        bottomCornerPosition2 = new Point(x, y);

        int[] xPoints = {
            topCornerPosition.x,
            bottomCornerPosition.x,
            bottomCornerPosition2.x
        };
        int[] yPoints = {
            topCornerPosition.y,
            bottomCornerPosition.y,
            bottomCornerPosition2.y
        };

        if (filled) {
            g2D.fillPolygon(xPoints, yPoints, 3);
        } else {
            g2D.drawPolygon(xPoints, yPoints, 3);
        }
    }

}
