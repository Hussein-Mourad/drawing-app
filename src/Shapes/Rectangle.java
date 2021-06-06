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
public class Rectangle implements Shape {

    private int width;
    private int height;
    private int x, y;
    float stroke = 1;
    Color color = Color.BLACK;
    private Point topCornerPosition;
    private Point bottomCornerPosition;

    public Rectangle(Point topCornerPosition, Point bottomCornerPosition) {
        this.topCornerPosition = topCornerPosition;
        this.bottomCornerPosition = bottomCornerPosition;
    }

    public Rectangle(Point topCornerPosition, Point bottomCornerPosition, float stroke) {
        this.topCornerPosition = topCornerPosition;
        this.bottomCornerPosition = bottomCornerPosition;
        this.stroke = stroke;
    }

    public Rectangle(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color) {
        this.topCornerPosition = topCornerPosition;
        this.bottomCornerPosition = bottomCornerPosition;
        this.stroke = stroke;
        this.color = color;
    }

    @Override
    public void draw(JPanel panel, Graphics2D g2D) {
        width = Math.abs((int) (bottomCornerPosition.getX() - topCornerPosition.getX()));
        height = Math.abs((int) (bottomCornerPosition.getY() - topCornerPosition.getY()));
        x = Math.min((int) bottomCornerPosition.getX(), (int) topCornerPosition.getX());
        y = Math.min((int) bottomCornerPosition.getY(), (int) topCornerPosition.getY());
        g2D.setStroke(new BasicStroke(stroke));
        g2D.setColor(color);
        g2D.drawRect(x, y, width, height);
        panel.repaint();
    }

    public Point getTopCornerPosition() {
        return topCornerPosition;
    }

    public void setTopCornerPosition(Point topCornerPosition) {
        this.topCornerPosition = topCornerPosition;
    }

    public Point getBottomCornerPosition() {
        return bottomCornerPosition;
    }

    public void setBottomCornerPosition(Point bottomCornerPosition) {
        this.bottomCornerPosition = bottomCornerPosition;
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

    public float getStroke() {
        return stroke;
    }

    public void setStroke(float stroke) {
        this.stroke = stroke;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

//    public void remove() {
//
//    }
    public String getPosition() {
        return topCornerPosition.toString();
    }

    public void setPosition(Point p) {
        topCornerPosition.setLocation(p);
    }

    public int getX() {
        return (int) topCornerPosition.getX();
    }

    public int getY() {
        return (int) topCornerPosition.getY();
    }

}
