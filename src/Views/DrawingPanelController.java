/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Shapes.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
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
    private boolean fill = false;
    private DrawingPanel panel;
    private FreeLine tmpLine;
    private Shape tmpShape;
    private boolean dragMode = false;
    private Shape currentMovingShape;
    private Point currentMovingShapePrevPt;

    public DrawingPanelController(DrawingPanel panel) {
        this.panel = panel;
    }

    public void mousePressed(MouseEvent evt, ShapesEnum shape) {
//
        if (dragMode) {
            currentMovingShapePrevPt = evt.getPoint();
        }
        if (shape != null) {

            switch (shape) {
                case RECTANGLE:
                    Rectangle rectangle = new Rectangle(evt.getPoint(), evt.getPoint(), stroke, color, fill);
                    shapes.add(rectangle);
                    break;
                case SQUARE:
                    Square square = new Square(evt.getPoint(), evt.getPoint(), stroke, color, fill);
                    shapes.add(square);
                    break;
                case STRAIGHTLINE:
                    StraightLine straightLine = new StraightLine(evt.getPoint(), evt.getPoint(), stroke, color);
                    shapes.add(straightLine);
                    break;
                case FREELINE:
                    tmpLine = new FreeLine(evt.getPoint(), evt.getPoint(), stroke, color);
                    shapes.add(tmpLine);
                    tmpLine.addPoint(evt.getPoint());
                    break;
                case ELLIPSE:
                    Ellipse ellipse = new Ellipse(evt.getPoint(), evt.getPoint(), stroke, color, fill);
                    shapes.add(ellipse);
                    break;
                case CIRCLE:
                    Circle circle = new Circle(evt.getPoint(), evt.getPoint(), stroke, color, fill);
                    shapes.add(circle);
                    break;
                case TRIANGLE:
                    Triangle triangle = new Triangle(evt.getPoint(), evt.getPoint(), stroke, color, fill);
                    shapes.add(triangle);
                    break;
                default:
                    break;
            }
        }
    }

    public void mouseReleased(MouseEvent evt) {
        panel.getRectangleButton().setSelected(false);
        panel.getSquareButton().setSelected(false);
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        tmpLine = null;
    }

    public void mouseDragged(MouseEvent evt, ShapesEnum shape) {
        if (dragMode) {
            currentMovingShape.move(evt.getPoint(), currentMovingShapePrevPt);
            currentMovingShapePrevPt = evt.getPoint();
        }
        if (shape != null) {
            shapes.get(shapes.size() - 1).setBottomCornerPosition(evt.getPoint());

        }

        if (tmpLine != null) {
            tmpLine.addPoint(evt.getPoint());
        }
        panel.repaint();

    }

    public void mouseMoved(MouseEvent evt) {
        for (Shape shape : shapes) {
            if (shape.isMouseInside(evt.getPoint())) {
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                currentMovingShape = shape;
            } else {
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                currentMovingShape = null;
            }
        }
    }

    public void colorPicker() {
        ColorPicker colorPicker = new ColorPicker(this, panel);
        colorPicker.setVisible(true);
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void clearShapes() {
        shapes = new ArrayList<>();
        panel.repaint();
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

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public boolean isDragMode() {
        return dragMode;
    }

    public void setDragMode(boolean dragMode) {
        this.dragMode = dragMode;
    }

}
