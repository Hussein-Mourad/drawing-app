package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author hussein
 */
public class Rectangle extends Shape {

    int width;
    int height;

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

//    public Rectangle(Point topCornerPosition, int width, int height, float stroke, Color color) {
//        int x = (int) topCornerPosition.getX() + width;
//        int y = (int) topCornerPosition.getY() + height;
//        Point bottomPoint = new Point(x, y);
//        super(topCornerPosition, bottomPoint, stroke, color);
//    }
    @Override
    public void draw(Graphics2D g2D) {
        width = Math.abs((bottomCornerPosition.x - topCornerPosition.x));
        height = Math.abs((bottomCornerPosition.y - topCornerPosition.y));
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);

        if (fill) {
            g2D.fillRect(getDrawX(), getDrawY(), width, height);
        } else {
            g2D.drawRect(getDrawX(), getDrawY(), width, height);
        }
    }

//    @Override
//    public void move(Point currentPt, Point prevPt) {
//        topCornerPosition.translate(currentPt.x - prevPt.x, currentPt.y - prevPt.y);
//        bottomCornerPosition.translate(currentPt.x - prevPt.x, currentPt.y - prevPt.y);
//    }
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
