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
public class Square extends Rectangle {

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
    public void draw(Graphics2D g2D) {
        int bottomX =  Math.max(topCornerPosition.x, bottomCornerPosition.x);
        side = height = width = Math.abs(bottomX - getDrawX());
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);
        g2D.drawRect(getDrawX(), getDrawY(), side, side);
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

}
