/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.shapes;

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
    boolean filled = false;
    public int width, height;
//    boolean copied = false;

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
        this.filled = fill;
    }

    public Shape(Shape copy) { // copy constructor
        this.stroke = copy.stroke;
        this.color = copy.color;
        this.topCornerPosition = copy.topCornerPosition;
        this.bottomCornerPosition = copy.bottomCornerPosition;
        this.filled = copy.filled;
        this.width = copy.width;
        this.height = copy.height;
//        this.copied = true;
    }

    public abstract void draw(Graphics2D g2D);

    public void move(Point currentPt, Point prevPt) {
        topCornerPosition.translate(currentPt.x - prevPt.x, currentPt.y - prevPt.y);
        bottomCornerPosition.translate(currentPt.x - prevPt.x, currentPt.y - prevPt.y);
    }

//    abstract void resize();
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
        return filled;
    }

    public void setFill(boolean fill) {
        this.filled = fill;
    }

    public abstract boolean contains(Point mousePosition);
}
