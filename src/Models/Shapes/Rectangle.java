package Models.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author hussein
 */
public class Rectangle extends Shape {
//
//    int width;
//    int height;

    public Rectangle(Point topCornerPosition, Point bottomCornerPosition) {
        super(topCornerPosition, bottomCornerPosition);
    }

    public Rectangle(Point topCornerPosition, Point bottomCornerPosition, float stroke) {
        super(topCornerPosition, bottomCornerPosition, stroke);
    }

    public Rectangle(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color) {
        super(topCornerPosition, bottomCornerPosition, stroke, color);
    }

    public Rectangle(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color, boolean fill) {
        super(topCornerPosition, bottomCornerPosition, stroke, color, fill);
    }

    public Rectangle(Rectangle copy) { // copy constructor
        super(copy);
//        this.width = copy.width;
//        this.height = copy.height;
    }

    @Override
    public void draw(Graphics2D g2D) {
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);

//        if (!copied) {
        width = Math.abs((bottomCornerPosition.x - topCornerPosition.x));
        height = Math.abs((bottomCornerPosition.y - topCornerPosition.y));
        if (filled) {
            g2D.fillRect(getDrawX(), getDrawY(), width, height);
        } else {
            g2D.drawRect(getDrawX(), getDrawY(), width, height);
        }
//        } else {
//            if (filled) {
//                g2D.fillRect(topCornerPosition.x, topCornerPosition.y, width, height);
//            } else {
//                g2D.drawRect(topCornerPosition.x, topCornerPosition.y, width, height);
//            }
//        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        }
    }
}
