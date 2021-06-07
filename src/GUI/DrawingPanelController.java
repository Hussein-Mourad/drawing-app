/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Shapes.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author hussein
 */
public class DrawingPanelController {

    private ArrayList<Shape> shapes = new ArrayList<>();
    private ArrayList<Shape> clearedShape = new ArrayList<>();
    private float stroke = 1;
    private Color color = Color.BLACK;
    private DrawingPanel panel;

    public DrawingPanelController(DrawingPanel panel) {
        this.panel = panel;
    }

    public void mousePressed(MouseEvent evt, ShapesEnum shape) {
        switch (shape) {
            case RECTANGLE:
                Rectangle rectangle = new Rectangle(evt.getPoint(), evt.getPoint(), stroke, color);
                shapes.add(rectangle);
                break;
            case SQUARE:
                Square square = new Square(evt.getPoint(), evt.getPoint(), stroke, color);
                shapes.add(square);
                break;
            case STRAIGHTLINE:
                StraightLine straightLine = new StraightLine(evt.getPoint(), evt.getPoint(), stroke, color);
                shapes.add(straightLine);
                break;
            case ELLIPSE:
                Ellipse ellipse = new Ellipse(evt.getPoint(), evt.getPoint(), stroke, color);
                shapes.add(ellipse);
                break;
            case CIRCLE:
                Circle circle = new Circle(evt.getPoint(), evt.getPoint(), stroke, color);
                shapes.add(circle);
                break;
            case TRIANGLE:
                Triangle triangle = new Triangle(evt.getPoint(), evt.getPoint(), stroke, color);
                shapes.add(triangle);
                break;
        }
    }

    public void mouseReleased(MouseEvent evt) {
        panel.getRectangleButton().setSelected(false);
        panel.getSquareButton().setSelected(false);
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    public void mouseDragged(MouseEvent evt, ShapesEnum shape) {
        panel.repaint();
        shapes.get(shapes.size() - 1).setBottomCornerPosition(evt.getPoint());
    }

    public void colorPicker() {
        ColorPicker colorPicker = new ColorPicker(this, panel);
        colorPicker.setVisible(true);
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
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

}
