/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Shapes.Circle;
import Models.Shapes.Ellipse;
import Models.Shapes.FreeLine;
import Models.Shapes.Rectangle;
import Models.Shapes.Shape;
import Models.Shapes.ShapesEnum;
import Models.Shapes.Square;
import Models.Shapes.StraightLine;
import Models.Shapes.Triangle;
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

    private static DrawingPanelController instance = null;
    private ArrayList<Shape> shapes = new ArrayList<>(); // TODO convert to stack
    private ArrayList<Shape> clearedShapes = new ArrayList<>(); // TODO convert to stack
    private float stroke = 1;
    private Color color = Color.BLACK;
    private boolean fill = false;
    private DrawingPanel panel;
    private FreeLine tmpLine;
    private Shape tmpShape;
    private boolean insertMode = false;
    private boolean dragMode = false;
    private boolean deleteMode = false;
    private boolean fillMode = false;
    private Shape currentMovingShape;
    private Point currentMovingShapePrevPt;
    private boolean cleared = false;
    private boolean deleted = false;

    // private constructor restricted to this class itself
    private DrawingPanelController(DrawingPanel panel) {
        this.panel = panel;
    }

    // static method to create instance of Singleton class
    public static DrawingPanelController getInstance(DrawingPanel panel) {
        if (instance == null) {
            instance = new DrawingPanelController(panel);
        }
        return instance;
    }

    public void mousePressed(MouseEvent evt, ShapesEnum shape) {
//
        if (dragMode) {
            currentMovingShapePrevPt = evt.getPoint();
        }

        if (deleteMode) {
            deleteShape(evt.getPoint());
        }
        if (fillMode) {
            fillShape(evt.getPoint());
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
        resetCursor();
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
        if (dragMode) {
            for (Shape shape : shapes) {
                if (shape.isMouseInside(evt.getPoint())) {
                    panel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                    currentMovingShape = shape;
                } else {
                    resetCursor();
                    currentMovingShape = null;
                }
            }
        }
    }

    public void colorPicker() {
        ColorPicker colorPicker = new ColorPicker(this, panel);
        colorPicker.setVisible(true);
    }

    void undo() {
        if (deleted) {
            redo();
            deleted = false;
        } else {
            clearedShapes.add(shapes.get(shapes.size() - 1));
            shapes.remove(shapes.size() - 1);
            panel.repaint();
        }
    }

    void redo() {
        if (cleared) {
            shapes.addAll(clearedShapes);
            clearedShapes.clear();
            cleared = false;
        } else {
            shapes.add(clearedShapes.get(clearedShapes.size() - 1));
            clearedShapes.remove(clearedShapes.size() - 1);
        }
        panel.repaint();
    }

    void deleteShape(Point mousePosition) {
//        shapes.removeIf(shape -> shape.isMouseInside(evt.getPoint()));
        ArrayList<Shape> toRemove = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.isMouseInside(mousePosition)) {
                toRemove.add(shape);
            }
        }
        deleted = toRemove.size() != 0;
        clearedShapes.addAll(toRemove);
        shapes.removeAll(toRemove);
        panel.repaint();
    }

    void fillShape(Point mousePosition) {
        for (Shape shape : shapes) {
            if (shape.isMouseInside(mousePosition)) {
                shape.setFill(true);
                shape.setColor(color);
            }
        }
        panel.repaint();
    }

    public void clearShapes() {
        cleared = true;
        clearedShapes.addAll(shapes);
        shapes.clear();
        panel.repaint();
    }

    public void resetCursor() {
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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

    public boolean isDeleteMode() {
        return deleteMode;
    }

    public void setDeleteMode(boolean deleteMode) {
        if (deleteMode) {
            panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            resetCursor();
        }
        this.deleteMode = deleteMode;
    }

    public boolean isFillMode() {
        return fillMode;
    }

    public void setFillMode(boolean fillMode) {
        if (fillMode) {
            panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            resetCursor();
        }
        this.fillMode = fillMode;
    }

}
