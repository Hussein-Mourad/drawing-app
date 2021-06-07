/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

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

    public abstract void draw(Graphics2D g2D);
//    abstract void move();
//    abstract void resize();
//    abstract void area();

    int getDrawX() {
        return (int) Math.min(topCornerPosition.getX(), bottomCornerPosition.getX());
    }

    int getDrawY() {
        return (int) Math.min(topCornerPosition.getY(), bottomCornerPosition.getY());
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

    public int getX() {
        return (int) topCornerPosition.getX();
    }

    public int getY() {
        return (int) topCornerPosition.getY();
    }

}
