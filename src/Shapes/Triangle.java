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

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);
        int x = (int) (topCornerPosition.getX() - (bottomCornerPosition.getX() - topCornerPosition.getX()));
        int y = (int) bottomCornerPosition.getY();
        bottomCornerPosition2 = new Point(x, y);

        int[] xPoints = {
            (int) topCornerPosition.getX(),
            (int) bottomCornerPosition.getX(),
            (int) bottomCornerPosition2.getX()
        };
        int[] yPoints = {
            (int) topCornerPosition.getY(),
            (int) bottomCornerPosition.getY(),
            (int) bottomCornerPosition2.getY()
        };

        g2D.drawPolygon(xPoints, yPoints, 3);

//        g2D.draw(new Line2D.Float(
//                (float) topCornerPosition.getX(),
//                (float) topCornerPosition.getY(),
//                (float) bottomCornerPosition.getX(),
//                (float) bottomCornerPosition.getY()
//        ));
//        g2D.draw(new Line2D.Float(
//                (float) topCornerPosition.getX(),
//                (float) topCornerPosition.getY(),
//                (float) bottomCornerPosition2.getX(),
//                (float) bottomCornerPosition2.getY()
//        ));
//        g2D.draw(new Line2D.Float(
//                (float) bottomCornerPosition2.getX(),
//                (float) bottomCornerPosition2.getY(),
//                (float) bottomCornerPosition.getX(),
//                (float) bottomCornerPosition2.getY()
//        ));
    }

}
