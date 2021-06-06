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
import javax.swing.JPanel;

/**
 *
 * @author hussein
 */
public class Square extends Rectangle implements Shape {

    int side;

    public Square(Point topCornerPosition, Point bottomCornerPosition) {
        super(topCornerPosition, bottomCornerPosition);
    }

    public Square(Point topCornerPosition, Point bottomCornerPosition, float stroke) {
        super(topCornerPosition, bottomCornerPosition, stroke);
    }

    public Square(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color) {
        super(topCornerPosition, bottomCornerPosition, stroke, color);
    }

    @Override
    public void draw(JPanel panel, Graphics2D g2D) {
        int topX = Math.min((int) super.getTopCornerPosition().getX(), (int) super.getBottomCornerPosition().getX());
        int topY = Math.min((int) super.getTopCornerPosition().getY(), (int) super.getBottomCornerPosition().getY());
        int bottomX = Math.max((int) super.getTopCornerPosition().getX(), (int) super.getBottomCornerPosition().getX());
        super.setWidth(Math.abs(bottomX - topX));
        side = super.getWidth();
        super.setHeight(side);
        g2D.setStroke(new BasicStroke(super.getStroke()));
        g2D.setColor(super.getColor());
        g2D.drawRect(topX, topY, side, side);
        panel.repaint();
    }
}
