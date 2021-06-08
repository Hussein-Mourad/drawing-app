/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author hussein
 */
public abstract class Shape {

    float stroke = 1;
    Color color = Color.BLACK;
    Point topCornerPosition;
    Point bottomCornerPosition;
    boolean fill = false;

    public Shape(Point topCornerPosition, Point bottomCornerPosition) {
        this.topCornerPosition = topCornerPosition;
        this.bottomCornerPosition = bottomCornerPosition;
    }

    public Shape(Point topCornerPosition, Point bottomCornerPosition, float stroke) {
        this.topCornerPosition = topCornerPosition;
        this.bottomCornerPosition = bottomCornerPosition;
        this.stroke = stroke;
    }

    public Shape(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color) {
        this.topCornerPosition = topCornerPosition;
        this.bottomCornerPosition = bottomCornerPosition;
        this.stroke = stroke;
        this.color = color;
    }

    public Shape(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color, boolean fill) {
        this.topCornerPosition = topCornerPosition;
        this.bottomCornerPosition = bottomCornerPosition;
        this.stroke = stroke;
        this.color = color;
        this.fill = fill;
    }

    public Shape(Shape copy, Point mousePosition) { // copy constructor
        this.stroke = copy.stroke;
        this.color = copy.color;
        this.topCornerPosition = mousePosition;
        this.bottomCornerPosition = copy.bottomCornerPosition;
        this.fill = copy.fill;
    }

    public abstract void draw(Graphics2D g2D);

    public void move(Point currentPt, Point prevPt) {
        topCornerPosition.translate(currentPt.x - prevPt.x, currentPt.y - prevPt.y);
        bottomCornerPosition.translate(currentPt.x - prevPt.x, currentPt.y - prevPt.y);
    }
//    abstract void move();
//    abstract void resize();
//    abstract void area();

    public boolean isMouseInside(Point mousePosition) {
        if (mousePosition.x >= topCornerPosition.x
                && mousePosition.x <= bottomCornerPosition.x
                && mousePosition.y >= topCornerPosition.y
                && mousePosition.y <= bottomCornerPosition.y) {
            return true;
        }
        return false;
    }

    int getDrawX() {
        return Math.min(topCornerPosition.x, bottomCornerPosition.x);
    }

    int getDrawY() {
        return Math.min(topCornerPosition.y, bottomCornerPosition.y);
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

    public String getPosition() {
        return topCornerPosition.toString();
    }

    public void setPosition(Point p) {
        topCornerPosition.setLocation(p);
    }

    public double getX() {
        return topCornerPosition.getX();
    }

    public double getY() {
        return topCornerPosition.getY();
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

}
