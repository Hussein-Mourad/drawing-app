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

    public Square(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color, boolean fill) {
        super(topCornerPosition, bottomCornerPosition, stroke, color, fill);
    }

    public Square(Square copy) { // copy constructor
        super(copy);
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);

        if (!copied) {
            int bottomX = Math.max(topCornerPosition.x, bottomCornerPosition.x);
            side = height = width = Math.abs(bottomX - getDrawX());
            if (filled) {
                g2D.fillRect(getDrawX(), getDrawY(), width, height);
            } else {
                g2D.drawRect(getDrawX(), getDrawY(), width, height);
            }
        } else {
            side = height = width;
            if (filled) {
                g2D.fillRect(topCornerPosition.x, topCornerPosition.y, width, height);
            } else {
                g2D.drawRect(topCornerPosition.x, topCornerPosition.y, width, height);
            }
        }

    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

}
