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

//    public Rectangle(Point topCornerPosition, int width, int height, float stroke, Color color) {
//        int x = (int) topCornerPosition.getX() + width;
//        int y = (int) topCornerPosition.getY() + height;
//        Point bottomPoint = new Point(x, y);
//        super(topCornerPosition, bottomPoint, stroke, color);
//    }
    @Override
    public void draw(Graphics2D g2D) {
        width = Math.abs((int) (bottomCornerPosition.getX() - topCornerPosition.getX()));
        height = Math.abs((int) (bottomCornerPosition.getY() - topCornerPosition.getY()));
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);
        g2D.drawRect(getDrawX(), getDrawY(), width, height);
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
