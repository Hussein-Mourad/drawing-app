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
public class Ellipse extends Shape {

    int width;
    int height;
    Ellipse2D.Float ellipse;

    public Ellipse(Point topCornerPosition, Point bottomCornerPosition) {
        super(topCornerPosition, bottomCornerPosition);
    }

    public Ellipse(Point topCornerPosition, Point bottomCornerPosition, float stroke) {
        super(topCornerPosition, bottomCornerPosition, stroke);
    }

    public Ellipse(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color) {
        super(topCornerPosition, bottomCornerPosition, stroke, color);
    }

    public Ellipse(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color, boolean fill) {
        super(topCornerPosition, bottomCornerPosition, stroke, color, fill);
    }

    public Ellipse(Ellipse copy) { // copy constructor
        super(copy);
        this.width = copy.width;
        this.height = copy.height;
        this.ellipse = copy.ellipse;
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);

//        if (!copied) {
        width = Math.abs((bottomCornerPosition.x - topCornerPosition.x));
        height = Math.abs((bottomCornerPosition.y - topCornerPosition.y));
        ellipse = new Ellipse2D.Float(getDrawX(), getDrawY(), width, height);
//        } else {
//            ellipse = new Ellipse2D.Float(topCornerPosition.x, topCornerPosition.y, width, height);
//        }

        if (filled) {
            g2D.fill(ellipse);
        } else {
            g2D.draw(ellipse);
        }
    }

    @Override
    public boolean isMouseInside(Point mousePosition) {
        if (ellipse.contains(mousePosition)) {
            return true;
        }
        return false;
    }

}
