/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.app;

import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author hussein
 */
public class Rectanglefff {

    private int width;
    private int height;
//    private float strokeWidth = 1;
//    private Color strokeColor = Color.BLACK;
//    private Color fillColor = Color.BLACK;
    private Point position;

    public Rectanglefff() {

    }

    public Rectanglefff(int width, int height, Point position) {
        this.width = width;
        this.height = height;
        this.position = position;
    }

    public float getWidth() {
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

//    public float getStrokeWidth() {
//        return strokeWidth;
//    }
//
//    public void setStrokeWidth(float strokeWidth) {
//        this.strokeWidth = strokeWidth;
//    }
//    public int getStrokeColor() {
//        return strokeColor;
//    }
//    public void setStrokeColor(int strokeColor) {
//        this.strokeColor = strokeColor;
//    }
//    public int getFillColor() {
//        return fillColor;
//    }
//    public void setFillColor(int fillColor) {
//        this.fillColor = fillColor;
//    }
    public void draw(Graphics2D g2D, JPanel panel) {
        System.out.println(position + " " + width + " " + height);
        g2D.drawRect((int) position.getX(), (int) position.getY(), (int) width, (int) height);
        panel.repaint();
    }

//    public void remove() {
//
//    }
//    public String getPosition() {
//        return position.toString();
//    }
//
//    public void setPosition(Point p) {
//        position.setLocation(p);
//    }
//
    public int getX() {
        return (int) position.getX();
    }

    public int getY() {
        return (int) position.getY();
    }
}
