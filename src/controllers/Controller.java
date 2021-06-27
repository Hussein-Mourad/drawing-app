package controllers;

import models.ShapeFactory;
import models.shapes.Shape;
import views.MainFrame;

import java.awt.*;
import java.util.ArrayList;

public class Controller {
    private static Controller instance = null;
    public final String imgFolder = "/assets/images/";
    Mode mode = Mode.DEFAULT;
    Shape currentShape;
    ArrayList<Shape> shapes = new ArrayList<>();
    MainFrame frame;

    private Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void cut(Point mousePosition) {

    }

    public void copy(Point mousePosition) {
//        for (Shape shape : shapes) {
            ShapeFactory.cloneShape(shape);
//        }
    }

    public void paste(Point mousePosition) {

    }

    public void deleteShapeAtPoint(Point mousePosition) {
        shapes.stream()
                .filter(shape -> shape.contains(mousePosition))
                .findFirst().ifPresent(shape -> shapes.remove(shape));
    }

    public void fillShapeAtPoint(Point mousePosition) {
        shapes.stream()
                .filter(shape -> shape.contains(mousePosition))
                .findFirst().ifPresent(shape -> shape.setFilled(true));
    }

    public void clearAllShapes() {
        shapes.clear();
        frame.getCanvas().repaint();
    }

    public Mode getMode() {
        return mode;
    }

    public Controller setMode(Mode mode) {
        if (mode == INSERT) {
            throw new IllegalArgumentException("You must specify a shape in insert mode");
        } else if (mode == DEFAULT) {
            frame.getCanvas().setCursor(Cursor.getDefaultCursor());
        }
        this.mode = mode;
        return this;
    }

    public Controller setMode(Mode mode, Shapes shape) {
        this.mode = mode;
        frame.getCanvas().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        if (shape == Shapes.FREELINE) {
//            frame.getCanvas().setCursor(Cursor.getPredefinedCursor(Cursor.dwiN_RESIZE_CURSOR));
        }
        this.currentShape = shape;
        return this;
    }

    public Shapes getCurrentShape() {
        return currentShape;
    }

    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }

    public ArrayList<models.Shape> getShapes() {
        return shapes;
    }
}
